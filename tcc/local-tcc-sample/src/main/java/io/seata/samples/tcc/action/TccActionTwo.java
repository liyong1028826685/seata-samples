package io.seata.samples.tcc.action;

import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;

/**
 * The interface Tcc saga.io.seata.samples.action two.
 *
 * @author zhangsen
 */
@LocalTCC
public interface TccActionTwo {

    /**
     * Prepare boolean.
     *
     * @param actionContext the saga.io.seata.samples.action context
     * @param b             the b
     * @return the boolean
     */
    @TwoPhaseBusinessAction(name = "TccActionTwo" , commitMethod = "commit", rollbackMethod = "rollback")
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
