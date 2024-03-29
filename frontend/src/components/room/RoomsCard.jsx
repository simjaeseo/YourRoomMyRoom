import React, { useState } from "react";
import "./RoomsCard.scss";
import tmpImg from "@images/room.png";
function RoomsCard() {
  const [room, setRoom] = useState("");

  return (
    <div className="roomsCard">
      <img src={tmpImg} alt="방 사진" />
      <div className="roomsCard_detail flex">
        <div className="roomsCard_detail_line1 flex notoBold fs-20">
          <div className="roomsCard_detail_line1_price">월세 300/25</div>
          <div className="roomsCard_detail_line1_shape">원룸</div>
        </div>
        <div className="roomsCard_detail_line2 flex notoReg fs-15">
          <div className="roomsCard_detail_line2_region flex">광주 치평동</div>
          <div className="roomsCard_detail_line2_floor flex">3층</div>
          <div className="roomsCard_detail_line2_area flex">19.83㎡</div>
        </div>
        <div className="roomsCard_detail_line3 flex notoReg fs-15">
          <div className="roomsCard_detail_line3_adminCost flex">
            관리비 5만원
          </div>
          <div className="roomsCard_detail_line3_elevator flex">
            엘리베이터 O
          </div>
        </div>
      </div>
    </div>
  );
}

export default RoomsCard;
