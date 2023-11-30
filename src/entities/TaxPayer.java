package entities;

public class TaxPayer {
    private Double salaryIncome;
    private Double servicesIncome;
    private Double capitalIncome;
    private Double healthIncome;
    private Double educationSpending;

    public TaxPayer(Double salaryIncome, Double servicesIncome, Double capitalIncome, Double healthIncome, Double educationSpending) {
        this.salaryIncome = salaryIncome;
        this.servicesIncome = servicesIncome;
        this.capitalIncome = capitalIncome;
        this.healthIncome = healthIncome;
        this.educationSpending = educationSpending;
    }

    public Double getSalaryIncome() {
        return salaryIncome;
    }

    public void setSalaryIncome(Double salaryIncome) {
        this.salaryIncome = salaryIncome;
    }

    public Double getServicesIncome() {
        return servicesIncome;
    }

    public void setServicesIncome(Double servicesIncome) {
        this.servicesIncome = servicesIncome;
    }

    public Double getCapitalIncome() {
        return capitalIncome;
    }

    public void setCapitalIncome(Double capitalIncome) {
        this.capitalIncome = capitalIncome;
    }

    public Double getHealthIncome() {
        return healthIncome;
    }

    public void setHealthIncome(Double healthIncome) {
        this.healthIncome = healthIncome;
    }

    public Double getEducationSpending() {
        return educationSpending;
    }

    public void setEducationSpending(Double educationSpending) {
        this.educationSpending = educationSpending;
    }

    public double salaryTax() {
        double salaryPerMonth = salaryIncome / 12;
        if (salaryPerMonth < 3000) {
            return 0.0;
        } else if (salaryPerMonth >= 3000 && salaryPerMonth < 5000) {
            return salaryIncome * 0.1;
        } else {
            return salaryIncome * 0.2;
        }
    }

    public double servicesTax() {
        if (servicesIncome > 0) {
            return servicesIncome * 0.15;
        }
        return 0.0;
    }

    public double capitalTax() {
        if (capitalIncome > 0) {
            return capitalIncome * 0.2;
        }
        return 0.0;
    }

    public double grossTax() {
        return salaryTax() + servicesTax() + capitalTax();
    }

    public double taxRebate() {
        double maxRebateTax = grossTax() * 0.3;
        double spending = healthIncome + educationSpending;
        if (spending > 0) {
            if (spending < maxRebateTax) {
                return spending;
            } else {
                return maxRebateTax;
            }
        }
        return 0.0;
    }

    public double netTax() {
        return grossTax() - taxRebate();
    }

    @Override
    public String toString() {
        return "Imposto bruto total: " + String.format("%.2f\n", grossTax()) +
                "Abatimento: " + String.format("%.2f\n", taxRebate()) +
                "Imposto devido: " + String.format("%.2f\n", netTax());
    }
}
