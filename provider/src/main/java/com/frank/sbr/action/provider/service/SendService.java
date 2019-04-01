package com.frank.sbr.action.provider.service;

import com.frank.sbr.action.vo.CompanyVO;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-rocketmq-action
 * @package: com.frank.sbr.action.provider.service、
 * @email: cy880708@163.com
 * @date: 2019/4/1 下午1:58
 * @mofified By:
 */
public interface SendService {

    /**
     * @description：同步、异步、单向发送消息
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2019/4/1 下午1:37
     * @mofified By:
     */
    int sendSimpleMessage(CompanyVO companyVO);

    /**
     * @description：有序发送消息（顺序发送）
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2019/4/1 下午1:37
     * @mofified By:
     */
    int sendOrderMessage();

    /**
     * @description：广播发送消息
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2019/4/1 下午1:37
     * @mofified By:
     */
    int sendBroadcastingMessage();

    /**
     * @description：定时发送消息
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2019/4/1 下午1:38
     * @mofified By:
     */
    int sendScheduleMessage();

    /**
     * @description：批量消费消息
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2019/4/1 下午1:38
     * @mofified By:
     */
    int sendBatchMessage();

    /**
     * @description：条件过滤消费消息
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2019/4/1 下午1:38
     * @mofified By:
     */
    int sendFilterMessage();

    /**
     * @description：事务一致性消息
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2019/4/1 下午1:38
     * @mofified By:
     */
    int sendTransactionMessage();

}
