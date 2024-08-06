CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department IN VARCHAR2,
    p_bonus_percentage IN NUMBER
) IS
BEGIN
    UPDATE Employees
    SET Salary = Salary * (1 + p_bonus_percentage / 100), LastModified = SYSDATE
    WHERE Department = p_department;

    COMMIT;
END UpdateEmployeeBonus;
/
