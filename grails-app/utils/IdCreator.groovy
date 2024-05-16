class IdCreator {

    Random random = new Random()

    String createId() {
        return random.nextInt(1000000).toString()
    }
}
