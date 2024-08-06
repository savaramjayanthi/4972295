CREATE OR REPLACE PROCEDURE SafeTransferFunds (
    p_from_account_id IN NUMBER,
    p_to_account_id IN NUMBER,
    p_amount IN NUMBER
) AS
    insufficient_funds EXCEPTION;
    v_balance_from NUMBER;
BEGIN
    -- Check if the from account has sufficient funds
    SELECT Balance INTO v_balance_from FROM Accounts WHERE AccountID = p_from_account_id;
    IF v_balance_from < p_amount THEN
        RAISE insufficient_funds;
    END IF;

    -- Deduct the amount from the from account
    UPDATE Accounts
    SET Balance = Balance - p_amount, LastModified = SYSDATE
    WHERE AccountID = p_from_account_id;

    -- Add the amount to the to account
    UPDATE Accounts
    SET Balance = Balance + p_amount, LastModified = SYSDATE
    WHERE AccountID = p_to_account_id;

    COMMIT;

EXCEPTION
    WHEN insufficient_funds THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Insufficient funds in account ID ' || p_from_account_id);
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END SafeTransferFunds;
/
