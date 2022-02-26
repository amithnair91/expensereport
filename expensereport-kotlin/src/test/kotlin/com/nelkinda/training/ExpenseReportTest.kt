package com.nelkinda.training

import org.approvaltests.ApprovalUtilities
import org.approvaltests.Approvals
import org.junit.jupiter.api.Test
import java.util.Date

class ExpenseReportTest {

    @Test
    fun emptyExpenseReport() {
        val approval = ApprovalUtilities().writeSystemOutToStringBuffer()
        val date = Date(1645872240)

        ExpenseReport().printReport(date, emptyList())

        Approvals.verify(approval)
    }

}
