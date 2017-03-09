/**
 * Created by Administrator on 2017-03-08.
 */
var memory_values = [];
var memory_tile_ids = [];
var tiles_flipped = 0;

function clickTime(divid, image_pk, boardSize) {
    //setTimeout(window.location.reload.bind(window.location), 200);
    //document.getElementById('objekt').style.display = "none";


    // alert("divid " + divid);
    // alert("image_pk " + image_pk);
    // alert("boardsize " + boardSize);
    //
    //var FullShuffledBoard = boardSize;

    if (memory_values.length <2) {
        document.getElementById(divid).style.visibility = "hidden";

        if (memory_values.length == 0) {
            memory_values.push(image_pk);
            memory_tile_ids.push(divid);
        } else if (memory_values.length == 1) {
            memory_values.push(image_pk);
            memory_tile_ids.push(divid);
            if (memory_values[0] == memory_values[1]) {
                tiles_flipped += 2;
                // Clear both arrays
                memory_values = [];
                memory_tile_ids = [];
                // Check to see if the whole board is cleared
                if (tiles_flipped == boardSize) {
                    function winner() {
                        alert("We did it TEAM!");
                        window.location.reload()
                    } setTimeout(winner, 1000);

                }
            } else {
                function flip2Back() {
                    document.getElementById(memory_tile_ids[0]).style.visibility = "visible";
                    document.getElementById(memory_tile_ids[1]).style.visibility = "visible";
                    // Flip the 2 tiles back over
                    // var tile_1 = document.getElementById(memory_tile_ids[0]);
                    // var tile_2 = document.getElementById(memory_tile_ids[1]);
                    // tile_1.style.background = 'url(tile_bg.jpg) no-repeat';
                    // tile_1.innerHTML = "";
                    // tile_2.style.background = 'url(tile_bg.jpg) no-repeat';
                    // tile_2.innerHTML = "";
                    // Clear both arrays
                    memory_values = [];
                    memory_tile_ids = [];
                }
                setTimeout(flip2Back, 700);
            }
        }
    }
}


function memoryFlipTile(tile, val) {

}