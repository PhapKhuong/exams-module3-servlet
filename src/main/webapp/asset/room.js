var delRoomModal = document.getElementById("delRoomModal");
delRoomModal.addEventListener("show.bs.modal", function (event) {

    var button = event.relatedTarget;

    var roomId = button.getAttribute("data-bs-roomId");

    var modalBodyInputRoomId = delRoomModal.querySelector("#roomId");

    modalBodyInputRoomId.value = roomId;
});