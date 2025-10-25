public class Manager extends Employee {
    public Manager(double fixedSalary) {
        super(fixedSalary);
    }

    @Override
    public double calculateBonus(Department department) {
        if (department.reachedTarget()) {
            double baseBonus = getFixedSalary() * 0.20;
            double diff = department.getAchievedTargetValue() - department.getTargetValue();
            return baseBonus + diff * 0.01;
        }
        return 0.0;
    }
}
