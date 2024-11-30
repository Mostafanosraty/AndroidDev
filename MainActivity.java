import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

  private Spinner spinner;
  private ImageView imageView;
  private TextView textView;
  private String[] characters = { "Leonardo", "Donatello", "Raphael", "Michelangelo" };
  private int[] images = { R.drawable.leonardo, R.drawable.donatello, R.drawable.raphael, R.drawable.michelangelo };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    spinner = findViewById(R.id.spinner);
    imageView = findViewById(R.id.imageView);
    textView = findViewById(R.id.textView);

    ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, characters);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spinner.setAdapter(adapter);
    spinner.setOnItemSelectedListener(this);
  }
@Override
  public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
imageView.setImageResource(images[position]);
    textView.setText("you selected : " + characters[position]);
@Override
  public void onNothingSelected(AdapterView<?> parente) {
    Toast.makeText(this, "Nothing Selected", Toast.LENGTH_SHORT).show();
  }     
    } 
}
