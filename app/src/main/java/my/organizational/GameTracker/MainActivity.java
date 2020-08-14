package my.organizational.GameTracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.text.method.ScrollingMovementMethod;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    // ---------Declare each variable-------
    public final String SHARED_PREFS = "sharedPrefs";

    public ArrayList<String> PS1, PS2, PS3, PS4, Xbox, Xbox360, XboxOne, GB, GBC, GBA, DS, N3DS,
            N64, NGC, Dreamcast, Gamegear, NES, SNES;

    Button viewGamesBtn, addGameBtn, removeGameBtn;
    EditText consoleEditText, gameEditText;
    TextView madeBy, gameList;

    boolean firstTimeUsed = true;
    // ---------Declare each variable-------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PS1 = new ArrayList<String>();
        PS2 = new ArrayList<String>();
        PS3 = new ArrayList<String>();
        PS4 = new ArrayList<String>();
        Xbox = new ArrayList<String>();
        Xbox360 = new ArrayList<String>();
        XboxOne = new ArrayList<String>();
        GB = new ArrayList<String>();
        GBC = new ArrayList<String>();
        GBA = new ArrayList<String>();
        DS = new ArrayList<String>();
        N3DS = new ArrayList<String>();
        N64 = new ArrayList<String>();
        NGC = new ArrayList<String>();
        Dreamcast = new ArrayList<String>();
        Gamegear = new ArrayList<String>();
        NES = new ArrayList<String>();
        SNES = new ArrayList<String>();


        viewGamesBtn = findViewById(R.id.viewConsoleBtn);
        addGameBtn = findViewById(R.id.addGameBtn);
        removeGameBtn = findViewById(R.id.removeGameBtn);

        viewGamesBtn.setText("View Games");
        addGameBtn.setText("Add Game");
        removeGameBtn.setText("Remove Game");

        consoleEditText = findViewById(R.id.consoleText);
        gameEditText = findViewById(R.id.gameText);
        gameList = findViewById(R.id.gameList);

        consoleEditText.setHint("Console");
        gameEditText.setHint("Game");

        madeBy = findViewById(R.id.madeBy);
        madeBy.setText("Made By: " + RandomCreditEntry());
        gameList.setText("");
        gameList.setMovementMethod(new ScrollingMovementMethod());

        viewGamesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                madeBy.setVisibility(View.INVISIBLE);
                String consoleInput = consoleEditText.getText().toString();
                ViewGames(consoleInput);
            }
        });

        addGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gameInput = gameEditText.getText().toString();
                String consoleInput = consoleEditText.getText().toString();

                try {
                    AddGame(gameInput, consoleInput);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                gameEditText.setText("");
            }
        });
        removeGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gameInput = gameEditText.getText().toString();
                String consoleInput = consoleEditText.getText().toString();
                RemoveGame(gameInput, consoleInput);
                gameEditText.setText("");
            }
        });

        LoadData();
        CheckGameListEmpty();

    }

    // Check each array to make sure they are not empty. If it's not, then call OrganizeList(), and pass that array as a parameter.
    void CheckGameListEmpty() {
        if (!PS1.isEmpty()) {
            OrganizeList(PS1);
        }
        if (!PS2.isEmpty()) {
            OrganizeList(PS2);
        }
        if (!PS3.isEmpty()) {
            OrganizeList(PS3);
        }
        if (!PS4.isEmpty()) {
            OrganizeList(PS4);
        }
        if (!Xbox.isEmpty()) {
            OrganizeList(Xbox);
        }
        if (!Xbox360.isEmpty()) {
            OrganizeList(Xbox360);
        }
        if (!XboxOne.isEmpty()) {
            OrganizeList(XboxOne);
        }
        if (!GB.isEmpty()) {
            OrganizeList(GB);
        }
        if (!GBC.isEmpty()) {
            OrganizeList(GBC);
        }
        if (!GBA.isEmpty()) {
            OrganizeList(GBA);
        }
        if (!DS.isEmpty()) {
            OrganizeList(DS);
        }
        if (!N3DS.isEmpty()) {
            OrganizeList(N3DS);
        }
        if (!N64.isEmpty()) {
            OrganizeList(N64);
        }
        if (!NGC.isEmpty()) {
            OrganizeList(NGC);
        }
        if (!Dreamcast.isEmpty()) {
            OrganizeList(Dreamcast);
        }
        if (!Gamegear.isEmpty()) {
            OrganizeList(Gamegear);
        }
        if (!NES.isEmpty()) {
            OrganizeList(NES);
        }
        if (!SNES.isEmpty()) {
            OrganizeList(SNES);
        }
    }

    // User enters a string and that string will be compared to commonly used names for each console to find the one they want to work with, and show all the games the user has added to that console
    void ViewGames(String consoleName) {
        gameList.setText("");

        if (consoleName.equalsIgnoreCase("PS1") ||
                consoleName.equalsIgnoreCase("Playstation") ||
                consoleName.equalsIgnoreCase("Playstation 1") ||
                consoleName.equalsIgnoreCase("Playstation One")) {
            for (String game : PS1) {
                gameList.append(game + "\n");
            }
            OrganizeList(PS1);
        }
        if (consoleName.equalsIgnoreCase("PS2") ||
                consoleName.equalsIgnoreCase("Playstation 2") ||
                consoleName.equalsIgnoreCase("Playstation Two")) {
            for (String game : PS2) {
                gameList.append(game + "\n");
            }
            OrganizeList(PS2);
        }
        if (consoleName.equalsIgnoreCase("PS3") ||
                consoleName.equalsIgnoreCase("Playstation 3") ||
                consoleName.equalsIgnoreCase("Playstation Three")) {
            for (String game : PS3) {
                gameList.append(game + "\n");
            }
            OrganizeList(PS3);
        }
        if (consoleName.equalsIgnoreCase("PS4") ||
                consoleName.equalsIgnoreCase("Playstation 4") ||
                consoleName.equalsIgnoreCase("Playstation Four")) {
            for (String game : PS4) {
                gameList.append(game + "\n");
            }
            OrganizeList(PS4);
        }
        if (consoleName.equalsIgnoreCase("Xbox")) {
            for (String game : Xbox) {
                gameList.append(game + "\n");
            }
            OrganizeList(Xbox);
        }
        if (consoleName.equalsIgnoreCase("Xbox360") ||
                consoleName.equalsIgnoreCase("Xbox 360") ||
                consoleName.equalsIgnoreCase("X360")) {
            for (String game : Xbox360) {
                gameList.append(game + "\n");
            }
            OrganizeList(Xbox360);
        }
        if (consoleName.equalsIgnoreCase("XboxOne") ||
                consoleName.equalsIgnoreCase("Xbox One") ||
                consoleName.equalsIgnoreCase("Xbone")) {
            for (String game : XboxOne) {
                gameList.append(game + "\n");
            }
            OrganizeList(XboxOne);
        }
        if (consoleName.equalsIgnoreCase("GB") ||
                consoleName.equalsIgnoreCase("GameBoy")) {
            for (String game : GB) {
                gameList.append(game + "\n");
            }
            OrganizeList(GB);
        }
        if (consoleName.equalsIgnoreCase("GBC") ||
                consoleName.equalsIgnoreCase("GameboyColor") ||
                consoleName.equalsIgnoreCase("Game Boy Color") ||
                consoleName.equalsIgnoreCase("GameBoy Color")) {
            for (String game : GBC) {
                gameList.append(game + "\n");
            }
            OrganizeList(GBC);
        }
        if (consoleName.equalsIgnoreCase("GBA") ||
                consoleName.equalsIgnoreCase("GameBoyAdvance") ||
                consoleName.equalsIgnoreCase("GameBoy Advance")) {
            for (String game : GBA) {
                gameList.append(game + "\n");
            }
            OrganizeList(GBA);
        }
        if (consoleName.equalsIgnoreCase("DS") ||
                consoleName.equalsIgnoreCase("Nintendo DS") ||
                consoleName.equalsIgnoreCase("NDS") ||
                consoleName.equalsIgnoreCase("Nintendo Dual Screen") ||
                consoleName.equalsIgnoreCase("NintendoDualScreen")) {
            for (String game : DS) {
                gameList.append(game + "\n");
            }
            OrganizeList(DS);
        }
        if (consoleName.equalsIgnoreCase("N3DS") ||
                consoleName.equalsIgnoreCase("Nintendo 3DS") ||
                consoleName.equalsIgnoreCase("Nintendo3DS") ||
                consoleName.equalsIgnoreCase("3DS")) {
            for (String game : N3DS) {
                gameList.append(game + "\n");
            }
            OrganizeList(N3DS);
        }
        if (consoleName.equalsIgnoreCase("N64") ||
                consoleName.equalsIgnoreCase("Nintendo 64") ||
                consoleName.equalsIgnoreCase("Nintendo64")) {
            for (String game : N64) {
                gameList.append(game + "\n");
            }
            OrganizeList(N64);
        }
        if (consoleName.equalsIgnoreCase("NGC") ||
                consoleName.equalsIgnoreCase("Nintendo GameCube") ||
                consoleName.equalsIgnoreCase("GameCube")) {
            for (String game : NGC) {
                gameList.append(game + "\n");
            }
            OrganizeList(NGC);
        }
        if (consoleName.equalsIgnoreCase("Dreamcast") ||
                consoleName.equalsIgnoreCase("DC") ||
                consoleName.equalsIgnoreCase("Sega Dreamcast") ||
                consoleName.equalsIgnoreCase("SDC")) {
            for (String game : Dreamcast) {
                gameList.append(game + "\n");
            }
            OrganizeList(Dreamcast);
        }
        if (consoleName.equalsIgnoreCase("Gamegear") ||
                consoleName.equalsIgnoreCase("GG") ||
                consoleName.equalsIgnoreCase("Sega GameGear") ||
                consoleName.equalsIgnoreCase("SGG")) {
            for (String game : Gamegear) {
                gameList.append(game + "\n");
            }
            OrganizeList(Gamegear);
        }
        if (consoleName.equalsIgnoreCase("NES") ||
                consoleName.equalsIgnoreCase("Nintendo Entertainment System")) {
            for (String game : NES) {
                gameList.append(game + "\n");
            }
            OrganizeList(NES);
        }
        if (consoleName.equalsIgnoreCase("SNES") ||
                consoleName.equalsIgnoreCase("Super Nintendo Entertainment System")) {
            for (String game : SNES) {
                gameList.append(game + "\n");
            }
            OrganizeList(SNES);
        }
        gameList.setVisibility(View.VISIBLE);
    }

    // User enters a string and that string will be compared to commonly used names for each console to find the one they want to work with, and allows the user to input the name of any game they want to add to the list
    void AddGame(String gameName, String consoleName) throws Exception {

        if (consoleName.equalsIgnoreCase("PS1") ||
                consoleName.equalsIgnoreCase("Playstation") ||
                consoleName.equalsIgnoreCase("Playstation 1") ||
                consoleName.equalsIgnoreCase("Playstation One")) {
            for (String name : PS1) {
                if (name.equalsIgnoreCase(gameName)) {
                    Toast.makeText(this, "The game already exists!", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
            PS1.add(gameName);
            OrganizeList(PS1);
            Toast.makeText(this, "Added " + gameName, Toast.LENGTH_SHORT).show();
        }
        if (consoleName.equalsIgnoreCase("PS2") ||
                consoleName.equalsIgnoreCase("Playstation 2") ||
                consoleName.equalsIgnoreCase("Playstation Two")) {
            for (String name : PS2) {
                if (name.equalsIgnoreCase(gameName)) {
                    Toast.makeText(this, "The game already exists!", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
            PS2.add(gameName);
            OrganizeList(PS2);
            Toast.makeText(this, "Added " + gameName, Toast.LENGTH_SHORT).show();
        }
        if (consoleName.equalsIgnoreCase("PS3") ||
                consoleName.equalsIgnoreCase("Playstation 3") ||
                consoleName.equalsIgnoreCase("Playstation Three")) {
            for (String name : PS3) {
                if (name.equalsIgnoreCase(gameName)) {
                    Toast.makeText(this, "The game already exists!", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
            PS3.add(gameName);
            OrganizeList(PS3);
            Toast.makeText(this, "Added " + gameName, Toast.LENGTH_SHORT).show();
        }
        if (consoleName.equalsIgnoreCase("PS4") ||
                consoleName.equalsIgnoreCase("Playstation 4") ||
                consoleName.equalsIgnoreCase("Playstation Four")) {
            for (String name : PS4) {
                if (name.equalsIgnoreCase(gameName)) {
                    Toast.makeText(this, "The game already exists!", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
            PS4.add(gameName);
            OrganizeList(PS4);
            Toast.makeText(this, "Added " + gameName, Toast.LENGTH_SHORT).show();
        }
        if (consoleName.equalsIgnoreCase("Xbox")) {
            for (String name : Xbox) {
                if (name.equalsIgnoreCase(gameName)) {
                    Toast.makeText(this, "The game already exists!", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
            Xbox.add(gameName);
            OrganizeList(Xbox);
            Toast.makeText(this, "Added " + gameName, Toast.LENGTH_SHORT).show();
        }
        if (consoleName.equalsIgnoreCase("Xbox360") ||
                consoleName.equalsIgnoreCase("Xbox 360") ||
                consoleName.equalsIgnoreCase("X360")) {
            for (String name : Xbox360) {
                if (name.equalsIgnoreCase(gameName)) {
                    Toast.makeText(this, "The game already exists!", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
            Xbox360.add(gameName);
            OrganizeList(Xbox360);
            Toast.makeText(this, "Added " + gameName, Toast.LENGTH_SHORT).show();
        }
        if (consoleName.equalsIgnoreCase("XboxOne") ||
                consoleName.equalsIgnoreCase("Xbox One") ||
                consoleName.equalsIgnoreCase("Xbone")) {
            for (String name : XboxOne) {
                if (name.equalsIgnoreCase(gameName)) {
                    Toast.makeText(this, "The game already exists!", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
            XboxOne.add(gameName);
            OrganizeList(XboxOne);
            Toast.makeText(this, "Added " + gameName, Toast.LENGTH_SHORT).show();
        }
        if (consoleName.equalsIgnoreCase("GB") ||
                consoleName.equalsIgnoreCase("GameBoy")) {
            for (String name : GB) {
                if (name.equalsIgnoreCase(gameName)) {
                    Toast.makeText(this, "The game already exists!", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
            GB.add(gameName);
            OrganizeList(GB);
            Toast.makeText(this, "Added " + gameName, Toast.LENGTH_SHORT).show();
        }
        if (consoleName.equalsIgnoreCase("GBC") ||
                consoleName.equalsIgnoreCase("GameboyColor") ||
                consoleName.equalsIgnoreCase("Game Boy Color") ||
                consoleName.equalsIgnoreCase("GameBoy Color")) {
            for (String name : GBC) {
                if (name.equalsIgnoreCase(gameName)) {
                    Toast.makeText(this, "The game already exists!", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
            GBC.add(gameName);
            OrganizeList(GBC);
            Toast.makeText(this, "Added " + gameName, Toast.LENGTH_SHORT).show();
        }
        if (consoleName.equalsIgnoreCase("GBA") ||
                consoleName.equalsIgnoreCase("GameBoyAdvance") ||
                consoleName.equalsIgnoreCase("GameBoy Advance")) {
            for (String name : GBA) {
                if (name.equalsIgnoreCase(gameName)) {
                    Toast.makeText(this, "The game already exists!", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
            GBA.add(gameName);
            OrganizeList(GBA);
            Toast.makeText(this, "Added " + gameName, Toast.LENGTH_SHORT).show();
        }
        if (consoleName.equalsIgnoreCase("DS") ||
                consoleName.equalsIgnoreCase("Nintendo DS") ||
                consoleName.equalsIgnoreCase("NDS") ||
                consoleName.equalsIgnoreCase("Nintendo Dual Screen") ||
                consoleName.equalsIgnoreCase("NintendoDualScreen")) {
            for (String name : DS) {
                if (name.equalsIgnoreCase(gameName)) {
                    Toast.makeText(this, "The game already exists!", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
            DS.add(gameName);
            OrganizeList(DS);
            Toast.makeText(this, "Added " + gameName, Toast.LENGTH_SHORT).show();
        }
        if (consoleName.equalsIgnoreCase("N3DS") ||
                consoleName.equalsIgnoreCase("Nintendo 3DS") ||
                consoleName.equalsIgnoreCase("Nintendo3DS") ||
                consoleName.equalsIgnoreCase("3DS")) {
            for (String name : N3DS) {
                if (name.equalsIgnoreCase(gameName)) {
                    Toast.makeText(this, "The game already exists!", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
            N3DS.add(gameName);
            OrganizeList(N3DS);
            Toast.makeText(this, "Added " + gameName, Toast.LENGTH_SHORT).show();
        }
        if (consoleName.equalsIgnoreCase("N64") ||
                consoleName.equalsIgnoreCase("Nintendo 64") ||
                consoleName.equalsIgnoreCase("Nintendo64")) {
            for (String name : N64) {
                if (name.equalsIgnoreCase(gameName)) {
                    Toast.makeText(this, "The game already exists!", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
            N64.add(gameName);
            OrganizeList(N64);
            Toast.makeText(this, "Added " + gameName, Toast.LENGTH_SHORT).show();
        }
        if (consoleName.equalsIgnoreCase("NGC") ||
                consoleName.equalsIgnoreCase("Nintendo GameCube") ||
                consoleName.equalsIgnoreCase("GameCube")) {
            for (String name : NGC) {
                if (name.equalsIgnoreCase(gameName)) {
                    Toast.makeText(this, "The game already exists!", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
            NGC.add(gameName);
            OrganizeList(NGC);
            Toast.makeText(this, "Added " + gameName, Toast.LENGTH_SHORT).show();
        }
        if (consoleName.equalsIgnoreCase("Dreamcast") ||
                consoleName.equalsIgnoreCase("DC") ||
                consoleName.equalsIgnoreCase("Sega Dreamcast") ||
                consoleName.equalsIgnoreCase("SDC")) {
            for (String name : Dreamcast) {
                if (name.equalsIgnoreCase(gameName)) {
                    Toast.makeText(this, "The game already exists!", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
            Dreamcast.add(gameName);
            OrganizeList(Dreamcast);
            Toast.makeText(this, "Added " + gameName, Toast.LENGTH_SHORT).show();
        }
        if (consoleName.equalsIgnoreCase("Gamegear") ||
                consoleName.equalsIgnoreCase("GG") ||
                consoleName.equalsIgnoreCase("Sega GameGear") ||
                consoleName.equalsIgnoreCase("SGG")) {
            for (String name : Gamegear) {
                if (name.equalsIgnoreCase(gameName)) {
                    Toast.makeText(this, "The game already exists!", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
            Gamegear.add(gameName);
            OrganizeList(Gamegear);
            Toast.makeText(this, "Added " + gameName, Toast.LENGTH_SHORT).show();
        }
        if (consoleName.equalsIgnoreCase("NES") ||
                consoleName.equalsIgnoreCase("Nintendo Entertainment System")) {
            for (String name : NES) {
                if (name.equalsIgnoreCase(gameName)) {
                    Toast.makeText(this, "The game already exists!", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
            NES.add(gameName);
            OrganizeList(NES);
            Toast.makeText(this, "Added " + gameName, Toast.LENGTH_SHORT).show();
        }
        if (consoleName.equalsIgnoreCase("SNES") ||
                consoleName.equalsIgnoreCase("Super Nintendo Entertainment System")) {
            for (String name : SNES) {
                if (name.equalsIgnoreCase(gameName)) {
                    Toast.makeText(this, "The game already exists!", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
            SNES.add(gameName);
            OrganizeList(SNES);
            Toast.makeText(this, "Added " + gameName, Toast.LENGTH_SHORT).show();
        }
        SaveData();
        firstTimeUsed = false;
    }
    // User enters a string and that string will be compared to commonly used names for each console to find the one they want to work with, and allows the user to input the name of any game they want to remove from the list
    void RemoveGame(String gameName, String consoleName) {
        if (consoleName.equalsIgnoreCase("PS1") ||
                consoleName.equalsIgnoreCase("Playstation") ||
                consoleName.equalsIgnoreCase("Playstation 1") ||
                consoleName.equalsIgnoreCase("Playstation One")) {
            for (int x = 0; x < PS1.size(); x++) {
                if (PS1.get(x).equalsIgnoreCase(gameName)) {
                    PS1.remove(x);
                    Toast.makeText(this, "Removed " + gameName, Toast.LENGTH_SHORT).show();
                }
            }
            OrganizeList(PS1);
        }
        if (consoleName.equalsIgnoreCase("PS2") ||
                consoleName.equalsIgnoreCase("Playstation 2") ||
                consoleName.equalsIgnoreCase("Playstation Two")) {

            for (int x = 0; x < PS2.size(); x++) {
                if (PS2.get(x).equalsIgnoreCase(gameName)) {
                    PS2.remove(x);
                    Toast.makeText(this, "Removed " + gameName, Toast.LENGTH_SHORT).show();
                }
            }
            OrganizeList(PS2);
        }
        if (consoleName.equalsIgnoreCase("PS3") ||
                consoleName.equalsIgnoreCase("Playstation 3") ||
                consoleName.equalsIgnoreCase("Playstation Three")) {

            for (int x = 0; x < PS3.size(); x++) {
                if (PS3.get(x).equalsIgnoreCase(gameName)) {
                    PS3.remove(x);
                    Toast.makeText(this, "Removed " + gameName, Toast.LENGTH_SHORT).show();
                }
            }
            OrganizeList(PS3);
        }
        if (consoleName.equalsIgnoreCase("PS4") ||
                consoleName.equalsIgnoreCase("Playstation 4") ||
                consoleName.equalsIgnoreCase("Playstation Four")) {

            for (int x = 0; x < PS4.size(); x++) {
                if (PS4.get(x).equalsIgnoreCase(gameName)) {
                    PS4.remove(x);
                    Toast.makeText(this, "Removed " + gameName, Toast.LENGTH_SHORT).show();
                }
            }
            OrganizeList(PS4);
        }
        if (consoleName.equalsIgnoreCase("Xbox")) {

            for (int x = 0; x < Xbox.size(); x++) {
                if (Xbox.get(x).equalsIgnoreCase(gameName)) {
                    Xbox.remove(x);
                    Toast.makeText(this, "Removed " + gameName, Toast.LENGTH_SHORT).show();
                }
            }
            OrganizeList(Xbox);
            Toast.makeText(this, "Removed " + gameName, Toast.LENGTH_SHORT).show();
        }
        if (consoleName.equalsIgnoreCase("Xbox360") ||
                consoleName.equalsIgnoreCase("Xbox 360") ||
                consoleName.equalsIgnoreCase("X360")) {
            for (int x = 0; x < Xbox360.size(); x++) {
                if (Xbox360.get(x).equalsIgnoreCase(gameName)) {
                    Xbox360.remove(x);
                    Toast.makeText(this, "Removed " + gameName, Toast.LENGTH_SHORT).show();
                }
            }
            OrganizeList(Xbox360);
        }
        if (consoleName.equalsIgnoreCase("XboxOne") ||
                consoleName.equalsIgnoreCase("Xbox One") ||
                consoleName.equalsIgnoreCase("Xbone")) {
            for (int x = 0; x < XboxOne.size(); x++) {
                if (XboxOne.get(x).equalsIgnoreCase(gameName)) {
                    XboxOne.remove(x);
                    Toast.makeText(this, "Removed " + gameName, Toast.LENGTH_SHORT).show();
                }
            }
            OrganizeList(XboxOne);
        }
        if (consoleName.equalsIgnoreCase("GB") ||
                consoleName.equalsIgnoreCase("GameBoy")) {
            for (int x = 0; x < GB.size(); x++) {
                if (GB.get(x).equalsIgnoreCase(gameName)) {
                    GB.remove(x);
                    Toast.makeText(this, "Removed " + gameName, Toast.LENGTH_SHORT).show();
                }
            }
            OrganizeList(GB);
        }
        if (consoleName.equalsIgnoreCase("GBC") ||
                consoleName.equalsIgnoreCase("GameboyColor") ||
                consoleName.equalsIgnoreCase("Game Boy Color") ||
                consoleName.equalsIgnoreCase("GameBoy Color")) {
            for (int x = 0; x < GBC.size(); x++) {
                if (GBC.get(x).equalsIgnoreCase(gameName)) {
                    GBC.remove(x);
                    Toast.makeText(this, "Removed " + gameName, Toast.LENGTH_SHORT).show();
                }
            }
            OrganizeList(GBC);
        }
        if (consoleName.equalsIgnoreCase("GBA") ||
                consoleName.equalsIgnoreCase("GameBoyAdvance") ||
                consoleName.equalsIgnoreCase("GameBoy Advance")) {
            for (int x = 0; x < GBA.size(); x++) {
                if (GBA.get(x).equalsIgnoreCase(gameName)) {
                    GBA.remove(x);
                    Toast.makeText(this, "Removed " + gameName, Toast.LENGTH_SHORT).show();
                }
            }
            OrganizeList(GBA);
        }
        if (consoleName.equalsIgnoreCase("DS") ||
                consoleName.equalsIgnoreCase("Nintendo DS") ||
                consoleName.equalsIgnoreCase("NDS") ||
                consoleName.equalsIgnoreCase("Nintendo Dual Screen") ||
                consoleName.equalsIgnoreCase("NintendoDualScreen")) {
            for (int x = 0; x < DS.size(); x++) {
                if (DS.get(x).equalsIgnoreCase(gameName)) {
                    DS.remove(x);
                    Toast.makeText(this, "Removed " + gameName, Toast.LENGTH_SHORT).show();
                }
            }
            OrganizeList(DS);
        }
        if (consoleName.equalsIgnoreCase("N3DS") ||
                consoleName.equalsIgnoreCase("Nintendo 3DS") ||
                consoleName.equalsIgnoreCase("Nintendo3DS") ||
                consoleName.equalsIgnoreCase("3DS")) {

            for (int x = 0; x < N3DS.size(); x++) {
                if (N3DS.get(x).equalsIgnoreCase(gameName)) {
                    N3DS.remove(x);
                    Toast.makeText(this, "Removed " + gameName, Toast.LENGTH_SHORT).show();
                }
            }
            OrganizeList(N3DS);
        }
        if (consoleName.equalsIgnoreCase("N64") ||
                consoleName.equalsIgnoreCase("Nintendo 64") ||
                consoleName.equalsIgnoreCase("Nintendo64")) {
            for (int x = 0; x < N64.size(); x++) {
                if (N64.get(x).equalsIgnoreCase(gameName)) {
                    N64.remove(x);
                    Toast.makeText(this, "Removed " + gameName, Toast.LENGTH_SHORT).show();
                }
            }
            OrganizeList(N64);
        }
        if (consoleName.equalsIgnoreCase("NGC") ||
                consoleName.equalsIgnoreCase("Nintendo GameCube") ||
                consoleName.equalsIgnoreCase("GameCube")) {
            for (int x = 0; x < NGC.size(); x++) {
                if (NGC.get(x).equalsIgnoreCase(gameName)) {
                    NGC.remove(x);
                    Toast.makeText(this, "Removed " + gameName, Toast.LENGTH_SHORT).show();
                }
            }
            OrganizeList(NGC);
        }
        if (consoleName.equalsIgnoreCase("Dreamcast") ||
                consoleName.equalsIgnoreCase("DC") ||
                consoleName.equalsIgnoreCase("Sega Dreamcast") ||
                consoleName.equalsIgnoreCase("SDC")) {

            for (int x = 0; x < Dreamcast.size(); x++) {
                if (Dreamcast.get(x).equalsIgnoreCase(gameName)) {
                    Dreamcast.remove(x);
                    Toast.makeText(this, "Removed " + gameName, Toast.LENGTH_SHORT).show();
                }
            }
            OrganizeList(Dreamcast);
        }
        if (consoleName.equalsIgnoreCase("Gamegear") ||
                consoleName.equalsIgnoreCase("GG") ||
                consoleName.equalsIgnoreCase("Sega GameGear") ||
                consoleName.equalsIgnoreCase("SGG")) {
            for (int x = 0; x < Gamegear.size(); x++) {
                if (Gamegear.get(x).equalsIgnoreCase(gameName)) {
                    Gamegear.remove(x);
                    Toast.makeText(this, "Removed " + gameName, Toast.LENGTH_SHORT).show();
                }
            }
            OrganizeList(Gamegear);
        }
        if (consoleName.equalsIgnoreCase("NES") ||
                consoleName.equalsIgnoreCase("Nintendo Entertainment System")) {
            for (int x = 0; x < NES.size(); x++) {
                if (NES.get(x).equalsIgnoreCase(gameName)) {
                    NES.remove(x);
                    Toast.makeText(this, "Removed " + gameName, Toast.LENGTH_SHORT).show();
                }
            }
            OrganizeList(NES);
        }
        if (consoleName.equalsIgnoreCase("SNES") ||
                consoleName.equalsIgnoreCase("Super Nintendo Entertainment System")) {
            for (int x = 0; x < SNES.size(); x++) {
                if (SNES.get(x).equalsIgnoreCase(gameName)) {
                    SNES.remove(x);
                    Toast.makeText(this, "Removed " + gameName, Toast.LENGTH_SHORT).show();
                }
            }
            OrganizeList(SNES);
        }
        SaveData();
    }
    // Organizes all the games in alphabetical order
    void OrganizeList(ArrayList console) {
        gameList.setText("");
        for (int i = 0; i < console.size(); i++) {
            Collections.sort(console, String.CASE_INSENSITIVE_ORDER);
            gameList.append(console.get(i) + "\n");
        }
    }

    void SaveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("firstUse", firstTimeUsed);

        Set<String> ps1 = new HashSet<String>();
        Set<String> ps2 = new HashSet<String>();
        Set<String> ps3 = new HashSet<String>();
        Set<String> ps4 = new HashSet<String>();
        Set<String> xbox = new HashSet<String>();
        Set<String> xbox360 = new HashSet<String>();
        Set<String> xboxOne = new HashSet<String>();
        Set<String> gb = new HashSet<String>();
        Set<String> gbc = new HashSet<String>();
        Set<String> gba = new HashSet<String>();
        Set<String> ds = new HashSet<String>();
        Set<String> n3ds = new HashSet<String>();
        Set<String> n64 = new HashSet<String>();
        Set<String> ngc = new HashSet<String>();
        Set<String> dreamcast = new HashSet<String>();
        Set<String> gamegear = new HashSet<String>();
        Set<String> nes = new HashSet<String>();
        Set<String> snes = new HashSet<String>();

        ps1.addAll(PS1);
        ps2.addAll(PS2);
        ps3.addAll(PS3);
        ps4.addAll(PS4);
        xbox.addAll(Xbox);
        xbox360.addAll(Xbox360);
        xboxOne.addAll(XboxOne);
        gb.addAll(GB);
        gbc.addAll(GBC);
        gba.addAll(GBA);
        ds.addAll(DS);
        n3ds.addAll(N3DS);
        n64.addAll(N64);
        ngc.addAll(NGC);
        dreamcast.addAll(Dreamcast);
        gamegear.addAll(Gamegear);
        nes.addAll(NES);
        snes.addAll(SNES);

        editor.putStringSet("ps1key", ps1);
        editor.putStringSet("ps2key", ps2);
        editor.putStringSet("ps3key", ps3);
        editor.putStringSet("ps4key", ps4);
        editor.putStringSet("xboxkey", xbox);
        editor.putStringSet("xbox360key", xbox360);
        editor.putStringSet("xboxOnekey", xboxOne);
        editor.putStringSet("gbkey", gb);
        editor.putStringSet("gbckey", gbc);
        editor.putStringSet("gbakey", gba);
        editor.putStringSet("dskey", ds);
        editor.putStringSet("n3dskey", n3ds);
        editor.putStringSet("n64key", n64);
        editor.putStringSet("ngckey", ngc);
        editor.putStringSet("dreamcastkey", dreamcast);
        editor.putStringSet("gamegearkey", gamegear);
        editor.putStringSet("neskey", nes);
        editor.putStringSet("sneskey", snes);

        editor.apply();
        editor.commit();
    }

    void LoadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);

        Set<String> ps1 = sharedPreferences.getStringSet("ps1key", null);
        Set<String> ps2 = sharedPreferences.getStringSet("ps2key", null);
        Set<String> ps3 = sharedPreferences.getStringSet("ps3key", null);
        Set<String> ps4 = sharedPreferences.getStringSet("ps4key", null);
        Set<String> xbox = sharedPreferences.getStringSet("xboxkey", null);
        Set<String> xbox360 = sharedPreferences.getStringSet("xbox360key", null);
        Set<String> xboxOne = sharedPreferences.getStringSet("xboxOnekey", null);
        Set<String> gb = sharedPreferences.getStringSet("gbkey", null);
        Set<String> gbc = sharedPreferences.getStringSet("gbckey", null);
        Set<String> gba = sharedPreferences.getStringSet("gbakey", null);
        Set<String> ds = sharedPreferences.getStringSet("dskey", null);
        Set<String> n3ds = sharedPreferences.getStringSet("n3dskey", null);
        Set<String> n64 = sharedPreferences.getStringSet("n64key", null);
        Set<String> ngc = sharedPreferences.getStringSet("ngckey", null);
        Set<String> dreamcast = sharedPreferences.getStringSet("dreamcastkey", null);
        Set<String> gamegear = sharedPreferences.getStringSet("gamegearkey", null);
        Set<String> nes = sharedPreferences.getStringSet("neskey", null);
        Set<String> snes = sharedPreferences.getStringSet("sneskey", null);

        firstTimeUsed = sharedPreferences.getBoolean("firstUse", true);

        if (!firstTimeUsed) {
            PS1.addAll(ps1);
            PS2.addAll(ps2);
            PS3.addAll(ps3);
            PS4.addAll(ps4);
            Xbox.addAll(xbox);
            Xbox360.addAll(xbox360);
            XboxOne.addAll(xboxOne);
            GB.addAll(gb);
            GBC.addAll(gbc);
            GBA.addAll(gba);
            DS.addAll(ds);
            N3DS.addAll(n3ds);
            N64.addAll(n64);
            NGC.addAll(ngc);
            Dreamcast.addAll(dreamcast);
            Gamegear.addAll(gamegear);
            NES.addAll(nes);
            SNES.addAll(snes);
        }
    }

    // Playing around with credits
    String RandomCreditEntry() {
        String madeByCredit = null;
        int max = 10;
        Random random = new Random();
        int num = random.nextInt(max + 1);

        switch (num) {
            case 0:
                madeByCredit = "Me!";
                break;
            case 1:
                madeByCredit = "Someone who was tired of forgetting his games!";
                break;
            case 2:
                madeByCredit = "Cristhian Vega";
                break;
            case 3:
                madeByCredit = "I'm not sure...";
                break;
            case 4:
                madeByCredit = "Meep";
                break;
            case 5:
                madeByCredit = "HoneybunHero";
                break;
            case 6:
                madeByCredit = "Cinco";
                break;
            case 7:
                madeByCredit = "Shyheart";
                break;
            case 8:
                madeByCredit = "A turtle";
                break;
            case 9:
                madeByCredit = "Insert credit here.";
                break;
            case 10:
                madeByCredit = "Coin operated!";
                break;
        }
        return madeByCredit;
    }
}