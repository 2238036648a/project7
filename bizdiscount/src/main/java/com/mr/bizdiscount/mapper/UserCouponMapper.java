package com.mr.bizdiscount.mapper;

import com.mr.bizdiscount.dto.UserCouponDTO;

public interface UserCouponMapper {

    int insertInfo(UserCouponDTO uc);

    int deleteCouponByCpId(String cpId);

    int updateUserCoupon(String cpId);

    int recoverUserCoupon(String cpId);
}
