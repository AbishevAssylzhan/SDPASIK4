# University Printing System
### Author: Assylzhan Abishev
### Group:SE-2512

## Description
This Java project simulates a university printing system.
A student can submit a PDF document for printing.
The price is 20 tenge per page per copy.
The queue can hold up to 3 jobs.

## Facade Pattern
PrintingFacade provides a simple interface for the client.
Its printDocument() method validates the document, calculates
the price, withdraws money, and adds a job to the queue.
If adding the job fails, the facade refunds the payment.

Main uses only PrintingFacade.
Subsystem classes do not reference the facade and can also
be used directly.

## Classes
- DocumentService: validates the file name, extension and page count.
- PriceCalculator: calculates the total price.
- BalanceService: manages payments and refunds.
- PrintQueue: stores and processes jobs in FIFO order.
- PrintingFacade: coordinates the subsystem classes.
- Main: demonstrates successful orders and errors.

## Clean Code Principles
1. Meaningful names:
   printDocument(), withdraw() and refund() describe their purpose.

2. Single Responsibility:
   Each subsystem has one responsibility.
   The facade coordinates operations without repeating their logic.

3. Encapsulation:
   Fields are private. The facade does not expose subsystem objects.

4. Small methods:
   Validation, calculation, payment and queue operations
   are separated into focused methods.

5. Error handling:
   Invalid input and a full queue produce clear exceptions.
   The facade refunds money when adding a job fails.

6. Named constants:
   PRICE_PER_PAGE and MAX_JOBS replace unexplained numbers.


