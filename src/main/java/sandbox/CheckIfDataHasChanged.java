package sandbox;

class CheckIfDataHasChanged {

    boolean checkData(String data) {
        return data.chars()
                .mapToObj(obj -> (char) obj)
                .allMatch(Character::isUpperCase);
    }

}
