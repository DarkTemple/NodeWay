var fs = require("fs");
var path = require("path");
var _ = require("underscore");
var klass = require("klass");
var randomstring = require("randomstring");

var gJavaTypesMap = {
    "Date":"date",
    "date":"date",
    "string":"string",
    "String":"string",
    "boolean":"bool",
    "bool":"bool",
    "Bool":"bool",
    "BOOL":"bool",
    "int":"int",
    "Int":"int",
    "long":"long",
    "Long":"long",
    "float":"float",
    "Float":"float",
    "double":"float",
    "Double":"float",
};

var gJavaRootClassName = "Object";

function print(object) {
    console.log(object);
}

function getSourceFileList(dirPath) {
    fileList = [];
    walk(dirPath);
    return fileList;
}

function walk(dirPath) {
    var dirList = fs.readdirSync(dirPath);
    dirList.forEach(function (item) {
        var extname = path.extname(item)
        if (!(extname == ".java")) {
            // only parse source code file
            return;
        }

        if (fs.statSync(dirPath + '/' + item).isFile()) {
            fileList.push(dirPath + '/' + item);
        }
    });

    dirList.forEach(function (item) {
        if (fs.statSync(dirPath + '/' + item).isDirectory()) {
            walk(dirPath + '/' + item);
        }
    });
}

function trimSpaceStr(input) {
    return input.replace(/\s/g, "");
}

var MCClassObject = klass(function (clsName, superClsName, properties) {
    this.clsName = clsName;
    this.superClsName = superClsName;
    this.properties = properties;
})

var commentReg1 = /\/\/[\s\S]*?\n/g;
var commentReg2 = /\/\*[\s\S]*?\*\//g;
var newLineReg = /\r\n/g;
var classDefineReg = /public\sclass\s(\w*)\sextends\s(\S*)[\s\S]*?\{([\s\S]*?)\}/g;
var propertiesReg = /public\s+([\s\S]*?)\s+(\w+)\s*?(=|;?)/g;
var collectionReg = /public\s+List\s*<([\s\S]+)>\s+(\w+)|Map\s*<([\s\S]+),([\s\S]+)>\s+(\w+)/;
var propItemReg = /public\s+(\w+)\s+(\w+)\s*=|public\s+(\w+)\s+(\w+)\s*$/;
var listTypeReg = /^\[([\S]+)\]$/;
var mapTypeReg = /^\{([\S]+?):([\S]+)\}$/;


function parseCodeToClassObj(path) {
    var clsObjList = [];
    var data = fs.readFileSync(path, "utf-8");
    if (!data) {
        console.log("read error");
    } else {
        data = data.replace(newLineReg, "\n");
        noCommentCode = data.replace(commentReg1, "").replace(commentReg2, "");
        while (classDef = classDefineReg.exec(noCommentCode)) {
            var className = classDef[1];
            var superClassName = _.last(classDef[2].split("."));
            var properties = classDef[3];
            var propMap = {};
            properties.split(";").forEach(function (propItem) {
                var propType;
                var propName;
                if (res = collectionReg.exec(propItem)) {
                    // collection property
                    var matchList = (res[1] != undefined);
                    if (matchList) {
                        // List
                        propType = "[" + trimSpaceStr(res[1]) + "]"
                        propName = res[2];
                    } else {
                        propType = "{" + trimSpaceStr(res[3]) + ":" + trimSpaceStr(res[4]) + "}"
                        propName = res[5];
                    }

                    propMap[propName] = propType;
                } else {
                    res = propItemReg.exec(propItem);
                    if (res != null) {
                        propType = res[1] ? res[1] : res[3];
                        propName = res[1] ? res[2] : res[4];
                        propMap[propName] = propType;
                    }
                }
            });

            var clsObj = new MCClassObject(className, superClassName, propMap);
            clsObjList.push(clsObj);
        }
    }

    return clsObjList;
}

// random object data
var randListSize = 10;
var randMapSize = 3;

var gRandomOptions = {
    "defaultRandListSize":10,
    "defaultRandMapSize":3,
    "defaultRandIntLow":0,
    "defaultRandIntHigh":100,
    "defaultRandLongLow":10000000,
    "defaultRandLongHigh":9999999999,
    "defaultRandFloatLow":0,
    "defaultRandFloatHigh":100,
};

function randDataWithPropType(type, low, high, listSize, mapSize) {
    if (gJavaTypesMap[type]) {
        return randDataWithPrimeType(gJavaTypesMap[type], low, high);
    } else if (res = listTypeReg.exec(type)) {
        // List
        var listSize = listSize || gRandomOptions.defaultRandListSize;
        var randListData = [];
        var elemType = res[1];
        for (var i=0; i<listSize; i++) {
            var elemItem = randDataWithPropType(elemType, low, high);
            randListData.push(elemItem);
        }

        return randListData;
    } else if (res = mapTypeReg.exec(type)) {
        // Map
        var mapSize = mapSize || gRandomOptions.defaultRandMapSize;
        var randMapData = {};
        var elemKeyType = res[1];
        var elemValType = res[2];
        for (var i=0; i<mapSize; i++) {
            var elemKey = randDataWithPropType(elemKeyType, low, high);
            var elemValue = randDataWithPropType(elemValType, low, high);
            randMapData[elemKey] = elemValue;
        }

        return randMapData;
    } else {
        // Object
        return randClassData(type, listSize, mapSize);
    }
}

function randDataWithPrimeType(type, low, high) {
    var randRes;
    switch (type) {
//        "date", "string", "boolean", "int", "long", "float", "double"
        case "date":
            randRes = "2015-08-22";
            break;
        case "string":
            randRes = "Random string " + randomstring.generate(5);
            break;
        case "bool":
            randRes = Math.random() > 0.5;
            break;
        case "int":
            var low = low || gRandomOptions.defaultRandIntLow;
            var high = high || gRandomOptions.defaultRandIntHigh;
            randRes = Math.floor(randDataWithPrimeType("float", low, high));
            break;
        case "long":
            var low = low || gRandomOptions.defaultRandLongLow;
            var high = high || gRandomOptions.defaultRandLongHigh;
            randRes = Math.floor(randDataWithPrimeType("float", low, high));
            break;
        case "float":
            var low = low || gRandomOptions.defaultRandFloatLow;
            var high = high || gRandomOptions.defaultRandFloatHigh;
            randRes = Math.random() * (high - low) + low;
            break;
        default:
            randRes = "";
    }

    return randRes;
}

function randClassData(clsName, listSize, mapSize) {
    var listSize = listSize || gRandomOptions.defaultRandListSize;
    var mapSize = mapSize || gRandomOptions.defaultRandMapSize;
    var clsObj = allClsObjListMap[clsName];
    if (!clsObj) {
        throw ("Can not find class : " + clsName);
    }
//    print(clsObj);
    var randomClassObjectData = {};
    // random super class
    var superCls = clsObj.superClsName;
    if (superCls == gJavaRootClassName) {
        _.extend(randomClassObjectData, {});
    } else {
        _.extend(randomClassObjectData, randClassData(superCls, listSize, mapSize));
    }

    // random properties
//    print(clsObj.properties);
    for (var propName in clsObj.properties) {
        var propType = clsObj.properties[propName];
        var randPropData = randDataWithPropType(propType, listSize=listSize, mapSize=mapSize);
        randomClassObjectData[propName] = randPropData;
    }

    return randomClassObjectData;
}

//print(randDataWithPropType("[{string:[int]}]"));

//for (var i=0; i<10; i++) {
//    print(randDataWithPropType("float"));
//}

//randClassData(allClsObjListMap, "ShopInfo");

//print(allClsObjListMap);

//printProp("/Users/haoquanbai/Work/NodeWay/lesson1/android/src");

// get all class desc obj
var sourceFileList = getSourceFileList("./src");
var allClsObjListMap = {};
for (var file in sourceFileList) {
    var clsObjList = parseCodeToClassObj(sourceFileList[file]);
    clsObjList.forEach(function (item) {
        var clsName = item.clsName;
        allClsObjListMap[clsName] = item;
    });
}

for (var clsName in allClsObjListMap) {
    print(clsName);
    print(randClassData(clsName));
}