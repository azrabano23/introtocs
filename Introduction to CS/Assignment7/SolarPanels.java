/**
 * Class represents solar panels, street map, and
 * an array of parking lot projects.
 * 
 * @author Jessica De Brito
 * @author Kal Pandit
 */
public class SolarPanels {
    
    private Panel[][] panels;
    private String[][] streetMap;
    private ParkingLot[] lots;

    /**
     * Default constructor: initializes empty panels and objects.
     */
    public SolarPanels() {
        panels = null;
        streetMap = null;
        lots = null;
        StdRandom.setSeed(2023);
    }

    /**
     * Updates the instance variable streetMap to be an l x w
     * array of Strings. Reads each label from input file in parameters.
     * 
     * @param streetMapFile the input file to read from
     */
    public void setupStreetMap(String streetMapFile) {
        StdIn.setFile(streetMapFile);
        // L x W
        int r = StdIn.readInt();
        int c = StdIn.readInt();
        streetMap = new String[r][c];
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                streetMap[i][j] = StdIn.readString();
            }
        }
    }

    /**
     * Adds parking lot information to an array of parking lots.
     * Updates the instance variable lots to store these parking lots.
     * 
     * @param parkingLotFile the lot input file to read
     */
    public void setupParkingLots(String parkingLotFile) {
        StdIn.setFile(parkingLotFile);

        int n = StdIn.readInt();
        lots = new ParkingLot[n];
        for (int i = 0; i < n; i++) {
            // The Varibles: 
            String lotName = StdIn.readString();
            int maxPanels = StdIn.readInt();
            double budget = StdIn.readDouble();
            int energyCapacity = StdIn.readInt();
            double panelEfficiency = StdIn.readDouble();
            // Parking Lot: 
            ParkingLot lot = new ParkingLot(lotName, maxPanels, budget, energyCapacity, panelEfficiency);
            lots[i] = lot;
        }
    }

    /**
     * Insert panels on each lot as much as space and budget allows.
     * Updates the instance variable panels to be a 2D array parallel to
     * streetMap, storing panels placed.
     * 
     * Panels have a 95% chance of working. Use StdRandom.uniform(); if
     * the resulting value is < 0.95 the panel works.
     * 
     * @param costPerPanel the fixed cost per panel, as a double
     */
    public void insertPanels(double costPerPanel) {
        panels = new Panel[streetMap.length][streetMap[0].length];
        for(int i = 0; i < lots.length; i++){ // Traversing through Lots
            int curPaCount = 0;
            double curBudget = lots[i].getBudget();
            for(int j = 0; j < streetMap.length; j++){ // Street Map
                for(int k = 0; k < streetMap[0].length; k++){
                    if((streetMap[j][k].equals(lots[i].getLotName())) && (curBudget-costPerPanel >= 0) && (curPaCount < lots[i].getMaxPanels())){
                        boolean work = StdRandom.uniform() < 0.95;
                        panels[j][k] = new Panel(lots[i].getPanelEfficiency(), lots[i].getEnergyCapacity(), work);
                        curBudget -= costPerPanel;
                        curPaCount++;
                    }
                }
            }
        }
    }

    /**
     * Given a temperature and coefficient, update panels' actual efficiency
     * values. Panels are most optimal at 77 degrees F.
     * 
     * Panels perform worse in hotter environments and better in colder ones.
     * worse = efficiency loss, better = efficiency gain.
     * 
     * Coefficients are usually negative to represent energy loss.
     * 
     * @param temperature the current temperature, in degrees F
     * @param coefficient the coefficient to use
     */
    public void updateActualEfficiency(int temperature, double coefficient) {
        for(int i = 0; i < panels.length ; i ++){
            for(int j = 0 ; j < panels[0].length;j++){
                if (panels[i][j] != null){
                    double EL = panels[i][j].getRatedEfficiency() - (coefficient * (temperature - 77));
                    panels[i][j].setActualEfficiency(EL);
                }
            }
        }
    }

    /**
     * For each WORKING panel, update the electricity generated for 4 hours 
     * of sunlight as follows:
     * 
     * (actual efficiency / 100) * 1500 * 4
     * 
     * RUN updateActualEfficiency BEFORE running this method.
     */
    public void updateElectricityGenerated() {
        for(int i = 0; i < panels.length ; i ++){
            for(int j = 0 ; j < panels[0].length;j++){
                if (panels[i][j] != null && panels[i][j].isWorking()){
                    double EG = (panels[i][j].getActualEfficiency() / 100) * 1500 * 4;
                    panels[i][j].setElectricityGenerated((int)EG);
                }
            }
        }
    }

    /**
     * Count the number of working panels in a parking lot.
     * 
     * @param parkingLot the parking lot name
     * @return the number of working panels
     */
    public int countWorkingPanels(String parkingLot) {
        int num = 0;
        for (int i = 0; i < streetMap.length; i++) {
            for (int j = 0; j < streetMap[0].length; j++) {
                if (parkingLot.equals(streetMap[i][j]) && panels[i][j] != null && panels[i][j].isWorking()) {
                    num++;
                }
            }
        }
        return num;
    }

    /**
     * Find the broken panels in the map and repair them.
     * @return the count of working panels in total, after repair
     */
    public int updateWorkingPanels() {
        int num = 0;
        for (int i = 0; i < streetMap.length; i++) {
            for (int j = 0; j < streetMap[0].length; j++) {
                if(panels[i][j] != null){
                    num++;
                    if (!panels[i][j].isWorking()) {
                        panels[i][j].setIsWorking(true);
                    }
                }
            }
        }
        return num;
    }

    /**
     * Calculate Rutgers' savings on energy by using
     * these solar panels.
     * 
     * ASSUME:
     * - Multiply total electricity generated by 0.001 to convert to KwH.
     * - There are 365 days in a year.
     * 
     * RUN electricityGenerated before running this method.
     */
    public double calculateSavings() {
        int TE = 0; // total electricity
        for (int i = 0; i < streetMap.length; i++) {
            for (int j = 0; j < streetMap[0].length; j++) {
                if(panels[i][j] != null){
                    TE += panels[i][j].getElectricityGenerated();
                }
            }
        }
        double pt1 = ((TE * 0.001) * 365);
        double pt2 = pt1 / 4270000;
        double pt3 = pt2 * 60000000;
        return pt3;
    }

    /*
     * Getter and Setter methods
     */
    public Panel[][] getPanels() {
        // DO NOT TOUCH THIS METHOD
        return this.panels;
    }

    public void setPanels(Panel[][] panels) {
        // DO NOT TOUCH THIS METHOD
        this.panels = panels;
    }

    public String[][] getStreetMap() {
        // DO NOT TOUCH THIS METHOD
        return this.streetMap;
    }

    public void setStreetMap(String[][] streetMap) {
        // DO NOT TOUCH THIS METHOD
        this.streetMap = streetMap;
    }

    public ParkingLot[] getLots() {
        // DO NOT TOUCH THIS METHOD
        return this.lots;
    }

    public void setLots(ParkingLot[] lots) {
        // DO NOT TOUCH THIS METHOD
        this.lots = lots;
    }
}