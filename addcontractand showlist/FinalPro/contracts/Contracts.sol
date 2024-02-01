// SPDX-License-Identifier: MIT
pragma solidity >=0.4.22 <0.9.0;

contract Contracts {
  struct Contract{
    string numeroContract;
    string idProprety;
    string ownerLand;
    string buyerLand;
    uint cost;
    string desc;
    string date;
  }
  address public owner;
   uint public PropretyCount = 0;

  mapping(uint => Contract) public Propreties;

  constructor() public{
    owner = msg.sender;
  }
 
  event Add(
    string numeroContract,
    string idProprety,
    string ownerLand,
    string buyerLand,
    uint cost,
    string desc,
    string date
  );


  modifier isOwner {
    require(msg.sender == owner);
    _;
  } 

  function addLand(string memory numeroContract,string memory idProprety, string memory _ownerLand,string memory _buyerLand,uint _cost, string memory _desc,string memory _date) public isOwner {

    require(_cost > 0, 'Must be a cost');

    PropretyCount++;

    Propreties[PropretyCount] = Contract(numeroContract,idProprety,_ownerLand,_buyerLand, _cost,_desc,_date);
    
    emit Add(numeroContract,idProprety,_ownerLand,_buyerLand, _cost,_desc,_date);
  }

  
  function getNumberLands() public view returns(uint){
      return PropretyCount;
  }

}
