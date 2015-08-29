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
   
public class ShopVO extends com.alipay.mappprod.common.service.facade.model.ToString
implements Serializable
 {

//Constants

  /** 
 * 门店id
 */
public String shopId;

  /** 
 * 门店名称，已作拼装： 鹿港小镇（金虹桥店）
 */
public String shopName;

  /** 
 * 门店所在的城市id 国标编码 
 */
public String cityId;

  /** 
 * 城市中文名
 */
public String cityName;

  /** 
 * 城市名拼音
 */
public String cityPinYin;


}//end of class def
