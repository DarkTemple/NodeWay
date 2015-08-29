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



import com.alipay.mappprod.core.model.platform.rpc.RpcModel;
import com.alipay.mappprod.biz.platform.rpc.vo.model.ShopVO;
   
public class ShopInfo extends com.alipay.mappprod.core.model.platform.rpc.RpcModel
implements Serializable
 {

//Constants

  /** 
 * 总记录数
 */
public int totalSize;

  /** 
 * 限制页数
 */
public int limitSize;

  /** 
 * 页尾提示
 */
public String tips;

  /** 
 * 门店列表
 */
public List<ShopVO> shopList;

public Map <String, ShopVO> shopList;


}//end of class def
