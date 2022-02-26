package com.nelkinda.training

import org.approvaltests.Approvals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.util.Date

class ExpenseReportTest {

    var outContent = ByteArrayOutputStream()

    @BeforeEach
    fun setup() {
        outContent = ByteArrayOutputStream()
        System.setOut(PrintStream(outContent));
    }

    @Test
    fun emptyExpenseReport() {
        val date = Date(1645872240)

        ExpenseReport().printReport(date, emptyList())

        Approvals.verify(outContent.toString())
    }

    @Test
    fun dinnerExpenseReport() {
        val date = Date(1645872240)

        ExpenseReport().printReport(
            date, listOf(
                createExpense(0, ExpenseType.DINNER),
                createExpense(-100, ExpenseType.DINNER),
                createExpense(1000, ExpenseType.DINNER),
                createExpense(4000, ExpenseType.DINNER),
                createExpense(5000, ExpenseType.DINNER),
                createExpense(1000000, ExpenseType.DINNER)
            )
        )

        assertEquals(
            "Expenses Tue Jan 20 05:11:12 GST 1970\n" +
                    "Dinner\t0\t \n" +
                    "Dinner\t-100\t \n" +
                    "Dinner\t1000\t \n" +
                    "Dinner\t4000\t \n" +
                    "Dinner\t5000\t \n" +
                    "Dinner\t1000000\tX\n" +
                    "Meal expenses: 1009900\n" +
                    "Total expenses: 1009900\n", outContent.toString()
        )
    }

    @Test
    fun breakfastExpenseReport() {
        val date = Date(1645872240)

        ExpenseReport().printReport(
            date, listOf(
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

        assertEquals(
            "Expenses Tue Jan 20 05:11:12 GST 1970\n" +
                    "Breakfast\t0\t \n" +
                    "Breakfast\t-100\t \n" +
                    "Breakfast\t999\t \n" +
                    "Breakfast\t1000\t \n" +
                    "Breakfast\t1001\tX\n" +
                    "Breakfast\t4000\tX\n" +
                    "Breakfast\t4999\tX\n" +
                    "Breakfast\t5000\tX\n" +
                    "Breakfast\t5001\tX\n" +
                    "Breakfast\t1000000\tX\n" +
                    "Meal expenses: 1021900\n" +
                    "Total expenses: 1021900\n", outContent.toString()
        )
    }

    private fun createExpense(amt: Int, expenseType: ExpenseType): Expense {
        val dinnerExpense = Expense()
        dinnerExpense.type = expenseType
        dinnerExpense.amount = amt
        return dinnerExpense
    }


}
