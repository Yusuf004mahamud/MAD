fun main() {

    println("Welcome to the Tenant Management System")

    //Variables

    println("VARIABLES")


    val tenantId = 1001
    val tenantName = "Tueny"
    val phoneNumber = "0712345678"
    val houseNumber = "E-107"
    val monthlyRent = 25000
    var amountPaid = 15000

    println("Tenant ID: $tenantId")
    println("Tenant Name: $tenantName")
    println("Phone Number: $phoneNumber")
    println("House Number: $houseNumber")
    println("Monthly Rent: KES $monthlyRent")
    println("Amount Paid: KES $amountPaid")


    println("\nUpdating Amount Paid")

    println("Amount paid before: $amountPaid")

    amountPaid = amountPaid + 5000

    println("Amount paid after: $amountPaid")


    /*
     * QUESTION 1.3:

     * What exact error message does IntelliJ show?
       IntelliJ gives an error of "Val cannot be reassigned"

     * Why does the compiler refuse?
       The compiler refuses because tenantId was declared using val because a val cannot be reassigned after initialization.

     * What single-word change would make it compile?
       By changing val to var.

     */

    //Data Types and Casting

    println("DATA TYPES")


    val tenantIdTyped: Int = 1001
    val tenantNameTyped: String = "Tueny"
    val phoneNumberTyped: String = "0712345678"
    val houseNumberTyped: String = "E-107"
    val monthlyRentTyped: Int = 25000
    var amountPaidTyped: Int = 20000

    println("Tenant ID: $tenantIdTyped")
    println("Tenant Name: $tenantNameTyped")
    println("Phone Number: $phoneNumberTyped")
    println("House Number: $houseNumberTyped")
    println("Monthly Rent: KES $monthlyRentTyped")
    println("Amount Paid: KES $amountPaidTyped")


    /*
     * Why is phoneNumber stored as a String and not an Int? Give two reasons.
       A phone number is not used for mathematical calculations.
       A phone number can begin with zero, which should be preserved.

     */

    val block: Char = 'A'
    val isActive: Boolean = true

    println("Block: $block")
    println("Is Active: $isActive")

    /*
     * Does it compile?
       No It does not compile. Kotlin does not automatically convert Int to Double. The error is caused by assigning an Int directly to Double. To fix it we use toDouble().

     */

    val rentAsDouble: Double = monthlyRentTyped.toDouble()

    println("Rent as Double: $rentAsDouble")

    /*
     Why does Kotlin require explicit Int -> Double conversion?
     Kotlin uses explicit conversions to make type conversions clear and prevent unexpected conversions or data problems.
     */

    val registrationNumber: Long = 999_999_999L

    println("Registration Number: $registrationNumber")

    /*
     The underscores make the number easier to read in the code. They do not appear in the console output.
     */

    //STRINGS

    println("STRINGS")


    println(
        tenantNameTyped + " lives in house " + houseNumberTyped
    )


    /*
     String templates are easier to read because variables can be placed directly inside the string.
     */

    println(
        "$tenantNameTyped lives in house $houseNumberTyped"
    )

    println(
        "Total rent for 6 months: KES ${monthlyRentTyped * 6}"
    )

    val receipt = """
        ===== RENT RECEIPT =====
        Tenant: $tenantNameTyped
        House: $houseNumberTyped
        Paid: KES $amountPaidTyped
    """.trimIndent()

    println(receipt)

    /*
     * QUESTION:
     * What happens to the indentation of a triple-quoted string?
       Without trimIndent(), the indentation written in the source code can appear in the output.
       trimIndent() removes the common indentation from each line, making the output properly aligned.
     */


    val greeting = "Dear Tenant"

    greeting.uppercase()

    println("Original: $greeting")
    println("Uppercase: ${greeting.uppercase()}")

    //OPERATORS
    println("OPERATORS")

    val balance = monthlyRentTyped - amountPaidTyped

    println("Balance: KES $balance")


    val wrongPercentPaid =
        (amountPaidTyped / monthlyRentTyped) * 100

    println("Wrong percentage: $wrongPercentPaid%")


    /*
     * QUESTION:
     * Fix it so that the output is 80%. Find two ways.
       Convert amountPaid to Double.
     */

    val percentPaid1 =
        (amountPaidTyped.toDouble() / monthlyRentTyped) * 100

    println("Method 1 - Paid: ${percentPaid1.toInt()}%")

    //Convert monthlyRent to Double.
    val percentPaid2 =
        (amountPaidTyped / monthlyRentTyped.toDouble()) * 100

    println("Method 2 - Paid: ${percentPaid2.toInt()}%")



    val instalment = 6000
    val rentAmount = 25000

    val fullInstalments = rentAmount / instalment
    val remainingAmount = rentAmount % instalment

    println("Full instalments: $fullInstalments")
    println("Remaining amount: KES $remainingAmount")


    //using numeric operator method syntax.


    val totalRent = monthlyRentTyped.times(6)

    println("Total rent: KES $totalRent")


    val isRentPaid = amountPaidTyped >= monthlyRentTyped

    println("Is rent fully paid? $isRentPaid")

    val monthsInArrears = 2

    val needsReminder =
        (amountPaidTyped < monthlyRentTyped) &&
                (monthsInArrears > 1)

    println("Needs reminder: $needsReminder")

    /*
     * QUESTION:
     * Change monthsInArrears to 1. What is needsReminder now and why?
     * It becomes false because the condition requires the tenant to be MORE than one month in arrears.
     */

    //MAKING DECISIONS

    println("DECISIONS")


    if (amountPaidTyped >= monthlyRentTyped) {
        println("Rent is fully paid")
    } else {
        println("Rent is outstanding")
    }

    /*
     * TEST RESULTS:
     *
     * amountPaid = 20000 -> Rent is outstanding
     * amountPaid = 25000 -> Rent is fully paid
     * amountPaid = 30000 -> Rent is fully paid
     */


    if (balance <= 0) {
        println("Rent is fully paid")
    } else if (balance < 10000) {
        println("Small outstanding balance")
    } else {
        println("Large outstanding balance")
    }

    when {
        balance <= 0 ->
            println("Rent is fully paid")

        balance < 10000 ->
            println("Small outstanding balance")

        else ->
            println("Large outstanding balance")
    }


    val arrearsMonths = 4

    when (arrearsMonths) {
        0 -> println("Rent is up to date")
        in 1..2 -> println("Early arrears")
        in 3..5 -> println("Serious arrears")
        in 6..12 -> println("Critical arrears")
        else -> println("Review tenant account")
    }

    /*
     * TEST VALUES:
     *
     * 0  -> Rent is up to date
     * 2  -> Early arrears
     * 4  -> Serious arrears
     * 8  -> Critical arrears
     * 15 -> Review tenant account
     */


    val tenantStatus = "ACTIVE"

    when (tenantStatus) {
        "ACTIVE" ->
            println("Tenant is currently active.")

        "VACATED" ->
            println("Tenant has vacated the house.")

        "PENDING" ->
            println("Tenant status is pending.")

        else ->
            println("Unknown tenant status.")
    }

    //RANGES AND LOOPS


    println("LOOPS")


    println("\nMonths of the year:")

    for (month in 1..12) {
        println(month)
    }



    //Printing every second month starting from month 1.


    println("\nPayment History:")

    for (month in 1..12 step 2) {
        println("Checking payment history for month $month")
    }



    //Printing a countdown from 5 down to 1.


    println("\nLease Countdown:")

    for (month in 5 downTo 1) {
        println(month)
    }


    val tenants = listOf(
        "Jane",
        "Brian",
        "Mary",
        "David"
    )

    println("\nTenant List:")

    for ((index, tenant) in tenants.withIndex()) {
        println("${index + 1}. $tenant")
    }

    /*
     * Why is it index + 1 and not index?
      Kotlin list indexes start at 0, while people normally number lists starting from 1.
     */


    /*
     * QUESTION
     * Set vacantHouses = 0.
     *
     * Version A:
     *
     * while (vacantHouses > 0) {
     *     println("Checking vacant houses...")
     * }
     *
     * Version B:
     *
     * do {
     *     println("Checking vacant houses...")
     * } while (vacantHouses > 0)
     *
     * ANSWER:
     * Version A prints 0 lines because the condition is false
     * before the loop starts.

     * Version B prints 1 line because do-while executes its body
     * once before checking the condition.
     */

    val vacantHouses = 0

    println("\nVersion A:")

    while (vacantHouses > 0) {
        println("Checking vacant houses...")
    }

    println("Version A printed 0 times.")

    println("\nVersion B:")

    do {
        println("Checking vacant houses...")
    } while (vacantHouses > 0)


    //Using repeat, print the reminder exactly 3 times.


    println("\nRent Reminders:")

    repeat(3) {
        println("Please pay your rent.")
    }

    //LISTS AND ARRAYS

    println("LISTS & ARRAYS")


    val tenantList = listOf(
        "Jane Wanjiku",
        "Brian Otieno",
        "Mary Achieng",
        "John Kamau"
    )

    println("First tenant: ${tenantList.first()}")
    println("Last tenant: ${tenantList[tenantList.size - 1]}")


    /*
     * QUESTION
     * Try to add David Mwangi to the list. What error do you get?
       A read-only List does not have an add() function.

     * What change is needed?
       Use of a mutableListOf() instead of listOf().

     */

    val mutableTenants = mutableListOf(
        "Jane Wanjiku",
        "Brian Otieno",
        "Mary Achieng",
        "John Kamau"
    )

    mutableTenants.add("David Mwangi")
    mutableTenants.remove("Brian Otieno")

    println("Final tenant list: $mutableTenants")
    println("Final list size: ${mutableTenants.size}")


    val houses = arrayOf(
        "A-101",
        "A-102",
        "A-103",
        "A-104"
    )

    println("Second house number: ${houses[1]}")

    houses[0] = "A-201"

    println("Updated array:")
    println(houses.joinToString())

    println("Space-separated:")
    println(houses.joinToString(" "))



    val houseNumbers = arrayOf("A-101", "A-102")

    println("Using joinToString:")
    println(houseNumbers.joinToString())

    println("Using contentToString:")
    println(houseNumbers.contentToString())


    val blockA = intArrayOf(1, 2, 3)
    val blockB = intArrayOf(4, 5, 6)

    val combined = blockA + blockB

    println("Block A + Block B:")
    println(combined.joinToString())


    val combinedReverse = blockB + blockA

    println("Block B + Block A:")
    println(combinedReverse.joinToString())

    /*
     * The + operator keeps the order of the arrays. Therefore blockB + blockA produces:
     * 4, 5, 6, 1, 2, 3
     */


    /*
     * QUESTION
     * State one thing a MutableList can do that an Array cannot.
       A MutableList can change its size by adding or removingelements, while an Array has a fixed size.

     * State one thing an Array can do that a read-only List cannot.
     * An Array can change an existing element using its index, while a read-only List cannot modify its elements.
     */

    //NULL SAFETY

    println("NULL SAFETY")


    /*
     * What is the error?
       Error is "Null can not be a value of a non-null type String"

     * What single character makes it legal?
       The question mark (?) makes String nullable.

     */

    var tenantEmail: String? = null

    println("Tenant email: $tenantEmail")

    /*
     * QUESTION:
     * Would you show "null" to a property manager?
       No. It would be better to display a meaningful message such as "Not provided".
     */

    println("Email: ${tenantEmail ?: "Not provided"}")

    tenantEmail = "jane@example.com"

    println("Email: ${tenantEmail ?: "Not provided"}")



    tenantEmail = null

    println("Safe call result: ${tenantEmail?.length}")

    println("Safe call + Elvis result: ${tenantEmail?.length ?: 0}")

    //We do not execute tenantEmail!!.length here because tenantEmail is null and it would terminate the program with a NullPointerException.



    var nextOfKin: String? = "Mary Wanjiku"

    println(
        "Next of kin: ${nextOfKin?.uppercase() ?: "No next of kin on record"}"
    )

    // Test when next of kin is not available.

    nextOfKin = null

    println(
        "Next of kin: ${nextOfKin?.uppercase() ?: "No next of kin on record"}"
    )


    println("FINAL REVIEW QUESTIONS")



    /*
     * QUESTION 1:
     * When would you deliberately choose var over val in this system?
       I would choose var when the value needs to change during program execution, such as amountPaid when the tenant makes another payment.
     */



    /*
     * QUESTION 2:
     * Why did (amountPaid / monthlyRent) * 100 give the wrong answer?
       Both amountPaid and monthlyRent were Int values, so Kotlin performed integer division first.

     * 20000 / 25000 = 0
     *
     * Therefore:
     *
     * 0 * 100 = 0
     */




    /*
     * QUESTION 3:
     * What is the difference between if/else if and when? When is each better?
       if/else if checks conditions one after another. when is useful for multiple possible conditions or cases and can make the code easier to read.
     */


    /*
     * QUESTION 4:
     * What is the difference between a List, MutableList and Array?
       List is read-only.
       MutableList allows elements to be added and removed.
       Array has a fixed size, but existing elements can be changed.
     */




    /*
     * QUESTION 5:
     * What does ?. do that !! does not?
       safely accesses a nullable value and returns null if the value is null.

     !! asserts that the value is not null and can cause a
     NullPointerException if the value is actually null.
     */



}