DECLARE
    CURSOR cur_loans IS
        SELECT LoanID
        FROM Loans;

    v_new_interest_rate NUMBER := 6; -- Example new policy interest rate

BEGIN
    FOR r IN cur_loans LOOP
        UPDATE Loans
        SET InterestRate = v_new_interest_rate, LastModified = SYSDATE
        WHERE LoanID = r.LoanID;
    END LOOP;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Interest rates updated successfully.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/
