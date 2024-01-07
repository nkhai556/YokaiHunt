package Map;

public class MapPaths {
    MapNodes start;
    MapNodes end;

    public MapPaths (MapNodes start, MapNodes end){
        this.start = start;
        this.end = end;
    }
    public MapNodes getStart(){
        return start;
    }
    public MapNodes getEnd(){
        return end;
    }
}
