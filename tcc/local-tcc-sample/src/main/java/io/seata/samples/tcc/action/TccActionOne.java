package io.seata.samples.tcc.action;

import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;

/**
 * The interface Tcc saga.io.seata.samples.action one.
 *
 * @author zhangsen
 */
@LocalTCC
public interface TccActionOne {

    /**
     * Prepare boolean.
     *
     * @param actionContext the saga.io.seata.samples.action context
     * @param a             the a
     * @return the boolean
     */
    @TwoPhaseBusinessAction(name = "TccActionOne" , commitMethod = "commit", rollbackMethod = "rollback")
    public boolean prepare(BusinessActionContext actionContext, int a);

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
