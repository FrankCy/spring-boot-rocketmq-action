package com.frank.sbr.action.consumer.service;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-rocketmq-action
 * @package: com.frank.sbr.action.provider.service、
 * @email: cy880708@163.com
 * @date: 2019/4/1 下午1:26
 * @mofified By:
 */
public interface MessageService {

    /**
     * @description：同步、异步、单向发送消息
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2019/4/1 下午1:37
     * @mofified By:
     */
    int simpleMessage();

    /**
     * @description：有序发送消息（顺序发送）
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2019/4/1 下午1:37
     * @mofified By:
     */
    int orderMessage();

    /**
     * @description：广播发送消息
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2019/4/1 下午1:37
     * @mofified By:
     */
    int broadcastingMessage();

    /**
     * @description：定时发送消息
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2019/4/1 下午1:38
     * @mofified By:
     */
    int scheduleMessage();

    /**
     * @description：批量消费消息
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2019/4/1 下午1:38
     * @mofified By:
     */
    int batchMessage();

    /**
     * @description：条件过滤消费消息
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2019/4/1 下午1:38
     * @mofified By:
     */
    int filterMessage();

    /**
     * @description：事务一致性消息
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2019/4/1 下午1:38
     * @mofified By:
     */
    int transactionMessage();
}
