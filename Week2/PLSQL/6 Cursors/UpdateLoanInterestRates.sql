DECLARE
    CURSOR cur_loans IS
        SELECT LoanID, InterestRate
        FROM Loans;

    v_new_interest_rate NUMBER := 6; -- Example new policy interest rate

BEGIN
    FOR r IN cur_loans LOOP
        UPDATE Loans
        SET InterestRate = v_new_interest_rate, LastModified = SYSDATE
        WHERE LoanID = r.LoanID;
    END LOOP;

    COMMIT;
END;
/
