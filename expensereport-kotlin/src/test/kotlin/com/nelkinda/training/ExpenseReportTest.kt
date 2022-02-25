package com.nelkinda.training

import org.approvaltests.ApprovalUtilities
import org.approvaltests.Approvals
import org.approvaltests.approvers.ApprovalApprover
import org.approvaltests.core.ApprovalWriter
import org.approvaltests.namer.ApprovalResults
import org.junit.jupiter.api.Test

class ExpenseReportTest {



    @Test
    fun emptyExpenseReport(){
        val approval = ApprovalUtilities().writeSystemOutToStringBuffer()

        ExpenseReport().printReport(emptyList())

        Approvals.verify(approval)
    }

}
