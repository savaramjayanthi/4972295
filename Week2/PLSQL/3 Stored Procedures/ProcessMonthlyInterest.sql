CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    FOR r IN (SELECT AccountID, Balance FROM Accounts WHERE AccountType = 'Savings') LOOP
        -- Calculate the new balance with 1% interest
        UPDATE Accounts
        SET Balance = Balance * 1.01, LastModified = SYSDATE
        WHERE AccountID = r.AccountID;
    END LOOP;

    COMMIT;
END ProcessMonthlyInterest;
/
