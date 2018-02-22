import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;

public class NET {

    private File dest;
    private String source;
    private long size;

    public NET(File saveto, String downloadfrom, long weight) {

        this.dest=saveto;
        this.source=downloadfrom;
        if(weight==-1){
            this.size=Long.MAX_VALUE;
        } else {
            this.size=weight;
        }
    }

    public void changeDestination(File saveto) {
        this.dest=saveto;
    }

    public void changeSource(String downloadfrom) {
        this.source=downloadfrom;
    }

    public void reconstruct(File saveto, String downloadfrom, long weight) {
        this.dest=saveto;
        this.source=downloadfrom;
        if(weight==-1){
            this.size=Long.MAX_VALUE;
        } else {
            this.size=weight;
        }
    }

    public boolean load() {
        try {
            URL src = new URL(this.source);
            FileOutputStream output = new FileOutputStream(this.dest.getAbsolutePath());
            output.getChannel().transferFrom(Channels.newChannel(src.openStream()), 0, Long.MAX_VALUE);
            if(this.dest.exists()) {
                return true;
            } else {
                return false;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
