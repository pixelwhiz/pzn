package programmerzamannow.belajarandroiddasar

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

class GameActivity : AppCompatActivity() {

    private lateinit var computerImageView: ImageView
    private lateinit var rockImageButton: ImageButton
    private lateinit var scissorsImageButton: ImageButton
    private lateinit var paperImageButton: ImageButton
    private lateinit var resultImageView: ImageView
    private lateinit var scoreView: TextView

    private var pscore = 0;
    private var cscore = 0;

    private fun initComponents() {
        computerImageView = findViewById(R.id.computerImageView)
        rockImageButton = findViewById(R.id.rockImageButton)
        scissorsImageButton = findViewById(R.id.scissorsImageButton)
        paperImageButton = findViewById(R.id.paperImageButton)
        resultImageView = findViewById(R.id.resultImageView)
        scoreView = findViewById(R.id.Score)
    }

    private fun initListeners() {
        rockImageButton.setOnClickListener { startGame("ROCK") }
        scissorsImageButton.setOnClickListener { startGame("SCISSORS") }
        paperImageButton.setOnClickListener { startGame("PAPER") }
    }

    private fun startGame(option: String) {
        val computerOption = Game.pickRandomOption()
        computerImageView.setImageResource(Game.pickDrawable(computerOption))

        when {
            Game.isDraw(option, computerOption) -> resultImageView.setImageResource(R.drawable.draw)
            Game.isWin(option, computerOption) -> {
                resultImageView.setImageResource(R.drawable.win)
                pscore++
                scoreView.text = "Your Score: ($pscore) Rizal Bot Score: ($cscore)"
            }
            else -> {
                resultImageView.setImageResource(R.drawable.lose)
                cscore++
                scoreView.text = "Your Score: ($pscore) Rizal Bot Score: ($cscore)"
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game)

        initComponents()
        initListeners()
    }

}