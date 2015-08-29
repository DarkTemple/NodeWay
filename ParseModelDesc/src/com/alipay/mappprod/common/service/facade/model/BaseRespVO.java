/*
 *generation date:Thu Jun 25 11:46:35 CST 2015
 *tool version:4.2.0
 *template version:4.1.1
 */
package com.alipay.mappprod.common.service.facade.model;

import java.lang.Boolean;
import java.lang.Byte;
import java.lang.Character;			
import java.lang.Double;
import java.lang.Float;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Short;
import java.lang.String;
import java.lang.Object;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Date;
import java.io.Serializable;
import com.alipay.mobile.framework.service.ext.annotation.CheckLogin;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.ext.BizResult;



   
public class BaseRespVO extends Object
implements Serializable
 {

//Constants

  /** 
 * 处理结果状态(0：FAIL, 1:SUCCESS, 2:UNKNOW)
 * @see com.alipay.mappprod.common.enums.ResultStatusEnum
 */
public int status=0;

  /** 
 * 错误代码 
 */
public String resultCode;

  /** 
 * 错误描述 
 */
public String resultDesc;

  /** 
 * 备注
 */
public String memo;

  /** 
 * 附加信息，方便扩展
 */
public Map<String,String> extInfos;


}//end of class def
