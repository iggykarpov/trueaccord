


Please email us the following once you are done:

A .zip or .tar.gz of your solution

A zip file as well as a repo link is included


A README.md file with the following information:



1 Clear, step-by-step instructions on how to run your application.

Run the main application class, DebtAdminConsoleApp. See the output in the console. 
For convenience, I am outputting all of the relevant entitiies in the JSON Lines format

2 A high level overview of how you spent your time.
 2.1 I have read the requirements a couple of times, to make sure I understood them fully. 
 2.2 Then I thought of the design of this app. Since it is very simple, I did not create any diagrams,
which I would do in a real design situation, i.e. UML diagrams, such as Class and Sequence.
 2.3 Wrote the unit tests. In some situations, I like to start with tests, i.e. follow TDD, but here 
I wrote the code first, due to the nature of the assignment - simple, and also better usage of time - 
it is more important to submit the code, in case I run out of time
 2.4 Used third-party http client, since i assume not everyone has java version 9 or later, with a built-in http client
 2.5  Please see the TODOs in code for what I would have improved, given more time

MY OUTPUT 


********************************** APPLICATION OUTPUT **********************************
********** DEBTS
{"id":0,"amount":123.46,"inPaymentPlan":true,"is_in_payment_plan":true,"remaining_amount":102.5,"next_payment_due_date":"2020-11-02"}
{"id":1,"amount":100.0,"inPaymentPlan":true,"is_in_payment_plan":true,"remaining_amount":100.0,"next_payment_due_date":"2020-08-15"}
{"id":2,"amount":4920.34,"inPaymentPlan":true,"is_in_payment_plan":true,"remaining_amount":4920.34,"next_payment_due_date":"2020-08-12"}
{"id":3,"amount":12938.0,"inPaymentPlan":true,"is_in_payment_plan":true,"remaining_amount":4312.67,"next_payment_due_date":"2020-08-22"}
{"id":4,"amount":9238.02,"inPaymentPlan":null,"is_in_payment_plan":null,"remaining_amount":9238.02,"next_payment_due_date":null}
********** PAYMENT PLANS
{"id":0,"debt_id":0,"amount_to_pay":102.5,"installment_frequency":"WEEKLY","installment_amount":51.25,"start_date":"2020-09-28"}
{"id":1,"debt_id":1,"amount_to_pay":100.0,"installment_frequency":"WEEKLY","installment_amount":25.0,"start_date":"2020-08-01"}
{"id":2,"debt_id":2,"amount_to_pay":4920.34,"installment_frequency":"BI_WEEKLY","installment_amount":1230.085,"start_date":"2020-01-01"}
{"id":3,"debt_id":3,"amount_to_pay":4312.67,"installment_frequency":"WEEKLY","installment_amount":1230.085,"start_date":"2020-08-01"}
********** PAYMENTS
{"amount":51.25,"date":"2020-09-29","payment_plan_id":0}
{"amount":51.25,"date":"2020-10-29","payment_plan_id":0}
{"amount":25.0,"date":"2020-08-08","payment_plan_id":1}
{"amount":25.0,"date":"2020-08-08","payment_plan_id":1}
{"amount":4312.67,"date":"2020-08-08","payment_plan_id":2}
{"amount":1230.085,"date":"2020-08-01","payment_plan_id":3}
{"amount":1230.085,"date":"2020-08-08","payment_plan_id":3}
{"amount":1230.085,"date":"2020-08-15","payment_plan_id":3}


