package io.seata.samples.tcc.sofarpc.action;

import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;

/**
 * The interface Tcc saga.io.seata.samples.action two.
 *
 * @author zhangsen
 */
public interface TccActionTwo {

    /**
     * Prepare boolean.
     *
     * @param actionContext the saga.io.seata.samples.action context
     * @param b             the b
     * @return the boolean
     */
    @TwoPhaseBusinessAction(name = "SofaRpcTccActionTwo" , commitMethod = "commit", rollbackMethod = "rollback")
    public boolean prepare(BusinessActionContext actionContext, String b);

    /**
     * Commit boolean.
     *
     * @param actionContext the saga.io.seata.samples.action context
     * @return the boolean
     */
    public boolean commit(BusinessActionContext actionContext);

    /**
     * Rollback boolean.
     *
     * @param actionContext the saga.io.seata.samples.action context
     * @return the boolean
     */
    public boolean rollback(BusinessActionContext actionContext);

}
