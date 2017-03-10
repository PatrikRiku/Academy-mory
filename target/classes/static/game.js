/**
 * Created by Administrator on 2017-03-08.
 */
var memory_values = [];
var memory_tile_ids = [];
var tiles_flipped = 0;
var numberOfClicks = 0;
function clickTime(divid, image_pk, boardSize) {


        if (divid != "locked" && memory_values.length <2) {
            document.getElementById(divid).style.opacity = 0;
            numberOfClicks += 1;
            if (memory_values.length == 0 && memory_tile_ids[1] != divid) {
                memory_values.push(image_pk);
                memory_tile_ids.push(divid);
            } else if (memory_values.length == 1 && memory_tile_ids[0] != divid) {
                memory_values.push(image_pk);
                memory_tile_ids.push(divid);
                if (memory_values[0] == memory_values[1]) {
                    tiles_flipped += 2;
                    document.getElementById(memory_tile_ids[0]).setAttribute("id", "locked");
                    document.getElementById(memory_tile_ids[1]).setAttribute("id", "locked");
                    // Clear both arrays
                    memory_values = [];
                    memory_tile_ids = [];
                    // Check to see if the whole board is cleared
                    if (tiles_flipped == boardSize) {
                        function winner() {
                            var name = prompt("We did it TEAM!\n You did it on: " + numberOfClicks + " tries\n What's your name?");
                            var xmlHttp = new XMLHttpRequest();
                            xmlHttp.open("GET", "http://localhost:8080/highscore/" + numberOfClicks + "/"+ name, false);
                            xmlHttp.send(null);
                            window.location.reload()
                        } setTimeout(winner, 3000);

                    }
                } else {
                    function flip2Back() {
                        document.getElementById(memory_tile_ids[0]).style.opacity = 1;
                        document.getElementById(memory_tile_ids[1]).style.opacity = 1;

                        memory_values = [];
                        memory_tile_ids = [];
                    }
                    setTimeout(flip2Back, 1000);

            }
        }
    }
}

