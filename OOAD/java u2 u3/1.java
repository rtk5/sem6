class HardcoverUI implements HardcoverAction {
    @Override
    public void seeReviews() {
        System.out.println("Displaying reviews for hardcover book...");
    }
    @Override
    public void searchSecondHand() {
        System.out.println("Searching for second-hand hardcover books...");
    }
}
class AudiobookUI implements AudiobookAction {
    @Override
    public void seeReviews() {
        System.out.println("Displaying reviews for audiobook...");
    }
    @Override
    public void listenSample() {
        System.out.println("Playing sample of audiobook...");
    }
}
