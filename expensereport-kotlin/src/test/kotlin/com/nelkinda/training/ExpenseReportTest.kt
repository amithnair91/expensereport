package com.nelkinda.training

import org.approvaltests.ApprovalUtilities
import org.approvaltests.Approvals
import org.junit.jupiter.api.Test
import java.util.*

class ExpenseReportTest {

    @Test
    fun emptyExpenseReport() {
        val date = Date(1645872240)
        val approval = ApprovalUtilities().writeSystemOutToStringBuffer()

        ExpenseReport().printReport(date, Expenses(emptyList()))

        Approvals.verify(approval)
    }

    @Test
    fun dinnerExpenseReport() {
        val date = Date(1645872240)
        val approval = ApprovalUtilities().writeSystemOutToStringBuffer()

        ExpenseReport().printReport(
            date, Expenses(
                listOf(
                    createExpense(0, ExpenseType.DINNER),
                    createExpense(-100, ExpenseType.DINNER),
                    createExpense(1000, ExpenseType.DINNER),
                    createExpense(4000, ExpenseType.DINNER),
                    createExpense(5000, ExpenseType.DINNER),
                    createExpense(1000000, ExpenseType.DINNER)
                )
            )
        )

        Approvals.verify(approval)
    }

    @Test
    fun breakfastExpenseReport() {
        val date = Date(1645872240)
        val approval = ApprovalUtilities().writeSystemOutToStringBuffer()

        ExpenseReport().printReport(
            date, Expenses(
                listOf(
                    createExpense(0, ExpenseType.BREAKFAST),
                    createExpense(-100, ExpenseType.BREAKFAST),
                    createExpense(999, ExpenseType.BREAKFAST),
                    createExpense(1000, ExpenseType.BREAKFAST),
                    createExpense(1001, ExpenseType.BREAKFAST),
                    createExpense(4000, ExpenseType.BREAKFAST),
                    createExpense(4999, ExpenseType.BREAKFAST),
                    createExpense(5000, ExpenseType.BREAKFAST),
                    createExpense(5001, ExpenseType.BREAKFAST),
                    createExpense(1000000, ExpenseType.BREAKFAST)
                )
            )
        )

        Approvals.verify(approval)
    }


    @Test
    fun carRentalExpenseReport() {
        val date = Date(1645872240)
        val approval = ApprovalUtilities().writeSystemOutToStringBuffer()

        ExpenseReport().printReport(
            date, Expenses(
                listOf(
                    createExpense(0, ExpenseType.CAR_RENTAL),
                    createExpense(-100, ExpenseType.CAR_RENTAL),
                    createExpense(999, ExpenseType.CAR_RENTAL),
                    createExpense(1000, ExpenseType.CAR_RENTAL),
                    createExpense(1001, ExpenseType.CAR_RENTAL),
                    createExpense(4000, ExpenseType.CAR_RENTAL),
                    createExpense(4999, ExpenseType.CAR_RENTAL),
                    createExpense(5000, ExpenseType.CAR_RENTAL),
                    createExpense(5001, ExpenseType.CAR_RENTAL),
                    createExpense(1000000, ExpenseType.CAR_RENTAL)
                )
            )
        )

        Approvals.verify(approval)
    }

    @Test
    fun miscellaneousExpenseReport() {
        val date = Date(1645872240)
        val approval = ApprovalUtilities().writeSystemOutToStringBuffer()

        ExpenseReport().printReport(
            date, Expenses(
                listOf(
                    createExpense(0, ExpenseType.CAR_RENTAL),
                    createExpense(-100, ExpenseType.BREAKFAST),
                    createExpense(999, ExpenseType.DINNER),
                    createExpense(1000, ExpenseType.CAR_RENTAL),
                    createExpense(1001, ExpenseType.BREAKFAST),
                    createExpense(4000, ExpenseType.DINNER)
                )
            )
        )

        Approvals.verify(approval)
    }


    private fun createExpense(amt: Int, expenseType: ExpenseType): Expense {
        val dinnerExpense = Expense()
        dinnerExpense.type = expenseType
        dinnerExpense.amount = amt
        return dinnerExpense
    }
}
