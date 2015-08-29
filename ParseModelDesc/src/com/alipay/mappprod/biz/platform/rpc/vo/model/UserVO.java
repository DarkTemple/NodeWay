/*
 *generation date:Thu Jun 25 11:44:09 CST 2015
 *tool version:4.2.0
 *template version:4.1.1
 */
package com.alipay.mappprod.biz.platform.rpc.vo.model;

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



import com.alipay.mappprod.common.service.facade.model.ToString;
   
public class UserVO extends com.alipay.mappprod.common.service.facade.model.ToString
implements Serializable
 {

//Constants

  /** 
 * 用户名
 */
public String userName;

  /** 
 * 头像
 */
public String logoUrl;

  /** 
 * 登陆的账号,脱敏处理过的登陆号
 */
public String hittedLogonId;

  /** 
 * 是否可用短密码
 */
public boolean shortPwdEnable;

public List <int> testList;
public Map <int, String> testMap;

}//end of class def
