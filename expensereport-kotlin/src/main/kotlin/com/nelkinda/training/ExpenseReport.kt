package com.nelkinda.training

import java.util.Date

enum class ExpenseType {
    DINNER, BREAKFAST, CAR_RENTAL
}

class Expense {
    lateinit var type: ExpenseType
    var amount: Int = 0

    fun isMeal() =
        this.type == ExpenseType.DINNER || this.type == ExpenseType.BREAKFAST

    fun name(): String {
        var expenseName = ""
        when (this.type) {
            ExpenseType.DINNER -> expenseName = "Dinner"
            ExpenseType.BREAKFAST -> expenseName = "Breakfast"
            ExpenseType.CAR_RENTAL -> expenseName = "Car Rental"
        }
        return expenseName
    }

    fun isOverLimit() =
        this.type == ExpenseType.DINNER && this.amount > 5000 || this.type == ExpenseType.BREAKFAST && this.amount > 1000
}

class ExpenseReport {
    fun printReport(expenses: List<Expense>) {
        val date = Date()
        printReport(date, expenses)
    }

    fun printReport(date: Date, expenses: List<Expense>) {
        println("Expenses $date")
        var total = 0
        var mealExpenses = 0


        for (expense in expenses) {
            if (expense.isMeal()) {
                mealExpenses += expense.amount
            }

            val expenseName = expense.name()
            val mealOverExpensesMarker = if (expense.isOverLimit()) "X" else " "

            println(expenseName + "\t" + expense.amount + "\t" + mealOverExpensesMarker)

            total += expense.amount
        }

        println("Meal expenses: $mealExpenses")
        println("Total expenses: $total")
    }

}
