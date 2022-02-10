package com.mr.mr_common.common;

/**
 * @ClassName CommonConstants
 * @Description: TODO
 * @Author 王某人
 * @Date 2020/7/23
 * @Version V1.0
 **/
public class CommonConstants {

    public static final String COUPON_CODE_PREFIX = "COUPON-NO-";

    //优惠券在redis里的值
    public static final String COUPON_REDIS_KEY = "REDIS-COUPON-LIST-KEY";

    //优惠券在redis里的值
    public static final String USER_REDIS_KEY = "REDIS-USER-LIST-KEY";

    public static final Integer OPEN_STATUS = 0;

    public static final String STORAGE_OUT_MEMORY = "There is no coupon store";

    public static final String PRODUCER_TOPIC_USERCOUPON = "userCouponTopic";

    public static final String PRODUCER_TAGS_USERCOUPON = "userCouponToptags";

    public static final String PRODUCT_STORAGE = "productStorage";

    public static final String    PRODUCT_STORAGE_TAGS = "productStorageTags";

    public static final String ORDER_DETAIL_TOPIC = "orderTopic";

    public static final String ORDER_DETAIL_ODCODE = "orderDetailOdCode";

    public static final String ORDER_DETAIL_TAGS = "orderToptags";

    public static final String DELETE_TOPIC_USERCOUPON = "deleteUserCouponTopic";

    public static final String DELETE_TAGS_USERCOUPON = "deleteUserCouponToptags";

    public static final String RECOVER_TOPIC_USERCOUPON = "recoverUserCouponTopic";

    public static final String RECOVER_TAGS_USERCOUPON = "recoverUserCouponToptags";


}
