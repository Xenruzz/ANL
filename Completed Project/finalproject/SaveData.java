/* Alex, Lado, Nathan
 * January 28, 2022
 * Save data class to store save data objects. Save datas are a name and a score
*/
package finalproject;


public class SaveData {
    
    private int score;
    private String name;
    
    /** Primary Constructor 
     * Creates a save data with a score and a name
     * @param s score 
     * @param n name
     */
    public SaveData(int s, String n) {
        score = s;
        name = n;
    }
    
    /** Get score method
     * Gets the score for this save data
     * @return the score variable
     */
    public int getScore() {
        return score;
    }
    
    /** Get name method
     * Gets the name for this save data
     * @return the name variable
     */
    public String getName() {
        return name;
    }
    
    /** toString method
     * Creates a detailed message about the current state of the save data
     * @return a String containing the values of the instance variables
     */
    @Override
    public String toString(){
        return "Name: " + name + "\nScore: " + score + "\n";
    }
    
    /** Equals method
     * checks if this save data is equal to another save data
     * @param otherData the other save data
     * @return true if they are equal, false if they are not
     */
    public boolean equals(SaveData otherData) {
        return (score == otherData.score && name.equalsIgnoreCase(otherData.name));
    }
    
    /** Clone method
     * Clones this save data
     * @return a new save data with the exact same attributes as this one
     */
    public SaveData clone() {
        SaveData clone = new SaveData(score, name);
        return clone;
    }
    
}
