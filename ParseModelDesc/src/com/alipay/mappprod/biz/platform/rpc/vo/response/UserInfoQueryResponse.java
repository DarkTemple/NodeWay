/*
 *generation date:Thu Jun 25 11:44:09 CST 2015
 *tool version:4.2.0
 *template version:4.1.1
 */
package com.alipay.mappprod.biz.platform.rpc.vo.response;

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



import com.alipay.mappprod.common.service.facade.model.BaseRespVO;
import com.alipay.mappprod.biz.platform.rpc.vo.model.UserVO;
import com.alipay.mappprod.biz.platform.rpc.vo.model.ShopInfo;
import com.alipay.mappprod.biz.platform.rpc.vo.model.ReceivePaymentVO;
   
public class UserInfoQueryResponse extends com.alipay.mappprod.common.service.facade.model.BaseRespVO
implements Serializable
 {

//Constants

  /** 
 * 用户信息
 */
public UserVO userVO;

  /** 
 * 门店信息
 */
public ShopInfo shopInfo;

  /** 
 * 收款信息
 */
public ReceivePaymentVO receivePayments;


}//end of class def
