DECLARE
    CURSOR cur_accounts IS
        SELECT AccountID, Balance
        FROM Accounts;

    v_fee NUMBER := 50; -- Example annual maintenance fee
    v_balance NUMBER;
    
BEGIN
    FOR r IN cur_accounts LOOP
        v_balance := r.Balance - v_fee;
        
        IF v_balance < 0 THEN
            v_balance := 0; -- Set balance to 0 if fee exceeds current balance
        END IF;
        
        UPDATE Accounts
        SET Balance = v_balance, LastModified = SYSDATE
        WHERE AccountID = r.AccountID;
    END LOOP;

    COMMIT;
END;
/
