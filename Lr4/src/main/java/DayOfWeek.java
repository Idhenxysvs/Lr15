public enum DayOfWeek {
    понедельник, вторник, среда, четверг, пятница, суббота, воскресенье;

    public String isWeekend() {
        return this == суббота || this == воскресенье ? "выходной" : "рабочий";
    }
}
