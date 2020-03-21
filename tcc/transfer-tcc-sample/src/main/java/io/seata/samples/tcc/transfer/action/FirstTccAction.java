package io.seata.samples.tcc.transfer.action;

import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;

/**
 * TCC参与者：扣钱
 *
 * @author zhangsen
 */
public interface FirstTccAction {
	
	/**
     * 一阶段方法
     * 
     * @param businessActionContext  框架会植入相关上下文信息
     *     [xid:192.168.3.3:8091:2038266211,branch_Id:2038266212,action_name:firstTccAction,action_context:{amount=10.0, action-start-time=1584539981286, sys::prepare=prepareMinus, accountNo=A, sys::rollback=rollback, sys::commit=commit, host-name=192.168.3.3, actionName=firstTccAction}]
     * @param accountNo @BusinessActionContextParameter参数也会被植入到事务上下文中
     * @param amount @BusinessActionContextParameter参数也会被植入到事务上下文中
     */
    @TwoPhaseBusinessAction(name = "firstTccAction", commitMethod = "commit", rollbackMethod = "rollback")
    public boolean prepareMinus(BusinessActionContext businessActionContext,
                                @BusinessActionContextParameter(paramName = "accountNo") String accountNo,
                                @BusinessActionContextParameter(paramName = "amount") double amount);

    /**
     * 二阶段提交
     * @param businessActionContext
     * @return
     */
    public boolean commit(BusinessActionContext businessActionContext);

    /**
     * 二阶段回滚
     * @param businessActionContext
     * @return
     */
    public boolean rollback(BusinessActionContext businessActionContext);
}
