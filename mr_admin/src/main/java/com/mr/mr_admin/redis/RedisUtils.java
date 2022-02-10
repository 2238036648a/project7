package com.mr.mr_admin.redis;

import com.mr.mr_common.commonenum.ErrorEnum;
import com.mr.mr_common.utils.CommonResultUtils;
import com.mr.mr_common.vo.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class RedisUtils {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 给普通数据赋值
     *
     * @param key
     * @return
     */

    public CommonResult setKeyValue(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return CommonResultUtils.getResult(ErrorEnum.SUCCESS_RESTUL.getErrCode(), ErrorEnum.SUCCESS_RESTUL.getErrMassage());
        } catch (Exception e) {
            log.error("set redis 异常");
            return CommonResultUtils.getResult(ErrorEnum.USER_CHECK.getErrCode(), ErrorEnum.USER_CHECK.getErrMassage());
        }
    }

    /**
     * 获取普通数据
     *
     * @param key
     * @return
     */

    public CommonResult getKeyValue(String key) {
        try {
            Object data = redisTemplate.opsForValue().get(key);
            return CommonResultUtils.getResult(ErrorEnum.SUCCESS_RESTUL.getErrCode(), ErrorEnum.SUCCESS_RESTUL.getErrMassage(), data);
        } catch (Exception e) {
            log.error("get redis 异常");
            return CommonResultUtils.getResult(ErrorEnum.USER_CHECK.getErrCode(), ErrorEnum.USER_CHECK.getErrMassage());
        }
    }

    /**
     * set hash值
     *
     * @param key
     * @return
     */
    public CommonResult setHashKeyValue(String key, String iterms, Object value) {
        try {
            redisTemplate.opsForHash().put(key, iterms, value);
            return CommonResultUtils.getResult(ErrorEnum.SUCCESS_RESTUL.getErrCode(), ErrorEnum.SUCCESS_RESTUL.getErrMassage());
        } catch (Exception e) {
            log.error("set redis 异常");
            return CommonResultUtils.getResult(ErrorEnum.USER_CHECK.getErrCode(), ErrorEnum.USER_CHECK.getErrMassage());
        }
    }


    public CommonResult setHashExpireKeyValue(String key, String iterms, Object value) {
        try {
            redisTemplate.opsForHash().put(key, iterms, value);
            expire(key, 10000, TimeUnit.MILLISECONDS);//毫秒值
            return CommonResultUtils.getResult(ErrorEnum.SUCCESS_RESTUL.getErrCode(), ErrorEnum.SUCCESS_RESTUL.getErrMassage());
        } catch (Exception e) {
            log.error("set redis 异常");
            return CommonResultUtils.getResult(ErrorEnum.USER_CHECK.getErrCode(), ErrorEnum.USER_CHECK.getErrMassage());
        }
    }


    /**
     * get hash某条数据
     *
     * @param key
     * @return
     */
    public CommonResult getHashKeyValue(String key, String iterms) {
        try {
            Object data = redisTemplate.opsForHash().get(key, iterms);
            return CommonResultUtils.getResult(ErrorEnum.SUCCESS_RESTUL.getErrCode(), ErrorEnum.SUCCESS_RESTUL.getErrMassage(), data);
        } catch (Exception e) {
            log.error("get redis 异常");
            return CommonResultUtils.getResult(ErrorEnum.USER_CHECK.getErrCode(), ErrorEnum.USER_CHECK.getErrMassage());
        }
    }

    /**
     * get hash全部值
     *
     * @param key
     * @return
     */

    public CommonResult getHashAllValue(String key) {
        try {
            Object data = redisTemplate.opsForHash().entries(key);
            return CommonResultUtils.getResult(ErrorEnum.SUCCESS_RESTUL.getErrCode(), ErrorEnum.SUCCESS_RESTUL.getErrMassage(), data);
        } catch (Exception e) {
            log.error("get redis 异常");
            return CommonResultUtils.getResult(ErrorEnum.USER_CHECK.getErrCode(), ErrorEnum.USER_CHECK.getErrMassage());
        }
    }


    public CommonResult setMapValue(String key, List<Map>map) {
        try {
            Object data = redisTemplate.opsForHash().get(key,map);
            return CommonResultUtils.getResult(ErrorEnum.SUCCESS_RESTUL.getErrCode(), ErrorEnum.SUCCESS_RESTUL.getErrMassage(), data);
        } catch (Exception e) {
            log.error("get redis 异常");
            return CommonResultUtils.getResult(ErrorEnum.USER_CHECK.getErrCode(), ErrorEnum.USER_CHECK.getErrMassage());
        }
    }


    /**
     * 给key值设置过期时间
     *
     * @param key expire
     * @return
     */
    public Long getExpire(String key, TimeUnit timeUnit) {
        return redisTemplate.getExpire(key, timeUnit);
    }

    public void expire(String key, long time, TimeUnit timeUnit) {
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, timeUnit);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("redis expire error", e);
        }
    }


    /**
     * 判断key是否存在
     *
     * @param key
     * @return
     */

    public Boolean keyExists(String key) {
       return redisTemplate.hasKey(key);
    }
}
