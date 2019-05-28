package com.yeungstech.qingcongxiaoyuan.wechat.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author: Kelvin Yeuung
 * @createdAt: 2019/5/9 22:54
 * @description: 微信统一下单
 */
@ApiModel
public class UnifiedOrder {


    @ApiModelProperty(name = "小程序ID", required = true, dataType = "String(32)", example = "wxd678efh567hg6787", notes = "微信分配的小程序ID")
    private String appid;

    @ApiModelProperty(name = "商户号", required = true, dataType = "String(32)", example = "1230000109", notes = "微信支付分配的商户号")
    private String mch_id;


    @ApiModelProperty(name = "设备号", required = false, dataType = "String(32)", example = "013467007045764", notes = "自定义参数，可以为终端设备号(门店号或收银设备ID)，PC网页或公众号内支付可以传\"WEB\"")
    private String device_info;


    @ApiModelProperty(name = "随机字符串", required = true, dataType = "String(32)", example = "5K8264ILTKCH16CQ2502SI8ZNMTM67VS", notes = "随机字符串，长度要求在32位以内。推荐随机数生成算法")
    private String nonce_str;


    @ApiModelProperty(name = "签名", required = true, dataType = "String(32)", example = "C380BEC2BFD727A4B6845133519F3AD6", notes = "通过签名算法计算得出的签名值，详见签名生成算法")
    private String sign;


    @ApiModelProperty(name = "签名类型", required = false, dataType = "String(32)", example = "MD5", notes = "签名类型，默认为MD5，支持HMAC-SHA256和MD5。")
    private String sign_type;

    @ApiModelProperty(name = "商品描述", required = true, dataType = "String(128)", example = "腾讯充值中心-QQ会员充值", notes = "商品简单描述，该字段请按照规范传递，具体请见参数规定")
    private String body;


    @ApiModelProperty(name = "商品详情", required = false, dataType = "String(6000)", example = "", notes = "商品详细描述，对于使用单品优惠的商户，该字段必须按照规范上传，详见“单品优惠参数说明”")
    private String detail;


    @ApiModelProperty(name = "附加数据", required = false, dataType = "String(127)", example = "深圳分店", notes = "附加数据，在查询API和支付通知中原样返回，可作为自定义参数使用。")
    private String attach;


    @ApiModelProperty(name = "商户订单号", required = true, dataType = "String(32)", example = "20150806125346", notes = "商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*且在同一个商户号下唯一。详见商户订单号")
    private String out_trade_no;


    @ApiModelProperty(name = "标价币种", required = false, dataType = "String(16)", example = "CNY", notes = "符合ISO 4217标准的三位字母代码，默认人民币：CNY，详细列表请参见货币类型")
    private String fee_type;


    @ApiModelProperty(name = "标价金额", required = true, dataType = "Int", example = "88", notes = "订单总金额，单位为分，详见支付金额")
    private Integer total_fee;


    @ApiModelProperty(name = "终端IP", required = true, dataType = "String(64)", example = "123.12.12.123", notes = "支持IPV4和IPV6两种格式的IP地址。调用微信支付API的机器IP")
    private String spbill_create_ip;


    @ApiModelProperty(name = "交易起始时间", required = false, dataType = "String(14)", example = "20091225091010", notes = "订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。其他详见时间规则")
    private String time_start;


    @ApiModelProperty(name = "交易结束时间", required = false, dataType = "String(14)", example = "20091227091010", notes = "订单失效时间，格式为yyyyMMddHHmmss，如2009年12月27日9点10分10秒表示为20091227091010。订单失效时间是针对订单号而言的，由于在请求支付的时候有一个必传参数prepay_id只有两小时的有效期，所以在重入时间超过2小时的时候需要重新请求下单接口获取新的prepay_id。其他详见时间规则\n\n建议：最短失效时间间隔大于1分钟")
    private String time_expire;


    @ApiModelProperty(name = "订单优惠标记", required = false, dataType = "String(32)", example = "WXG", notes = "订单优惠标记，使用代金券或立减优惠功能时需要的参数，说明详见代金券或立减优惠")
    private String goods_tag;


    @ApiModelProperty(name = "通知地址", required = true, dataType = "String(256)", example = "http://www.weixin.qq.com/wxpay/pay.php", notes = "异步接收微信支付结果通知的回调地址，通知url必须为外网可访问的url，不能携带参数。")
    private String notify_url;


    @ApiModelProperty(name = "交易类型", required = true, dataType = "String(16)", example = "JSAPI", notes = "小程序取值如下：JSAPI，详细说明见参数规定")
    private String trade_type;


    @ApiModelProperty(name = "商品ID", required = false, dataType = "String(32)", example = "12235413214070356458058", notes = "trade_type=NATIVE时，此参数必传。此参数为二维码中包含的商品ID，商户自行定义。")
    private String product_id;

    @ApiModelProperty(name = "指定支付方式", required = false, dataType = "String(32)", example = "no_credit", notes = "上传此参数no_credit--可限制用户不能使用信用卡支付")
    private String limit_pay;


    @ApiModelProperty(name = "用户标识", required = false, dataType = "String(128)", example = "oUpF8uMuAJO_M2pxb1Q9zNjWeS6o", notes = "trade_type=JSAPI，此参数必传，用户在商户appid下的唯一标识。openid如何获取，可参考【获取openid】。")
    private String openid;


    @ApiModelProperty(name = "电子发票入口开放标识", required = false, dataType = "String(8)", example = "Y", notes = "Y，传入Y时，支付成功消息和支付详情页将出现开票入口。需要在微信支付商户平台或微信公众平台开通电子发票功能，传此字段才可生效")
    private String receipt;

    @ApiModelProperty(name = "场景信息", required = false, dataType = "String(256)", example = "{\"store_info\" : {\\n \"id\": \"SZTX001\",\\n \"name\": \"腾大餐厅\",\\n \"area_code\": \"440305\",\\n\"address\": \"科技园中一路腾讯大厦\" }}", notes = "该字段常用于线下活动时的场景信息上报，支持上报实际门店信息，商户也可以按需求自己上报相关信息。该字段为JSON对象数据，对象格式为{\"store_info\":{\"id\": \"门店ID\",\"name\": \"名称\",\"area_code\": \"编码\",\"address\": \"地址\" }} ，字段详细说明请点击行前的+展开")
    private String scene_info;


    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMch_id() {
        return mch_id;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public String getDevice_info() {
        return device_info;
    }

    public void setDevice_info(String device_info) {
        this.device_info = device_info;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getSign_type() {
        return sign_type;
    }

    public void setSign_type(String sign_type) {
        this.sign_type = sign_type;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getFee_type() {
        return fee_type;
    }

    public void setFee_type(String fee_type) {
        this.fee_type = fee_type;
    }

    public Integer getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(Integer total_fee) {
        this.total_fee = total_fee;
    }

    public String getSpbill_create_ip() {
        return spbill_create_ip;
    }

    public void setSpbill_create_ip(String spbill_create_ip) {
        this.spbill_create_ip = spbill_create_ip;
    }

    public String getTime_start() {
        return time_start;
    }

    public void setTime_start(String time_start) {
        this.time_start = time_start;
    }

    public String getTime_expire() {
        return time_expire;
    }

    public void setTime_expire(String time_expire) {
        this.time_expire = time_expire;
    }

    public String getGoods_tag() {
        return goods_tag;
    }

    public void setGoods_tag(String goods_tag) {
        this.goods_tag = goods_tag;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getLimit_pay() {
        return limit_pay;
    }

    public void setLimit_pay(String limit_pay) {
        this.limit_pay = limit_pay;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public String getScene_info() {
        return scene_info;
    }

    public void setScene_info(String scene_info) {
        this.scene_info = scene_info;
    }



    @ApiModel(value = "场景信息")
    public static class SceneInfo {
        @ApiModelProperty(name = "门店id", required = false, dataType = "String(32)", example = "SZTX001", notes = "门店编号，由商户自定义")
        private String id;

        @ApiModelProperty(name = "门店名称", required = false, dataType = "String(64)", example = "腾讯大厦腾大餐厅", notes = "门店名称 ，由商户自定义")
        private String name;

        @ApiModelProperty(name = "门店行政区划码", required = false, dataType = "String(6)", example = "440305", notes = "门店所在地行政区划码，详细见《最新县及县以上行政区划代码》")
        private String area_code;

        @ApiModelProperty(name = "门店详细地址", required = false, dataType = "String(128)", example = "科技园中一路腾讯大厦", notes = "门店详细地址 ，由商户自定义")
        private String address;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getArea_code() {
            return area_code;
        }

        public void setArea_code(String area_code) {
            this.area_code = area_code;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }
}
