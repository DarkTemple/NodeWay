/*
 *generation date:Thu Jun 25 11:44:16 CST 2015
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
   
public class OperatorVO extends com.alipay.mappprod.common.service.facade.model.ToString
implements Serializable
 {

//Constants

  public String operatorId;

  /** 
 * 卡别名 
 */
public String cardAlias;

  /** 
 * 操作员code 
 */
public String operatorCode;

  /** 
 * 姓名
 */
public String operatorName;

  /** 
 * 店铺id
 */
public String shopId;

  /** 
 * 店铺名
 */
public String shopName;

  /** 
 * 状态
 */
public String operatorStatus;


}//end of class def
