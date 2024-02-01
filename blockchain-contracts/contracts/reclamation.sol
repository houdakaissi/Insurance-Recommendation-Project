// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.7.0 <0.9.0;

contract ReclamationContract {
    struct Reclamation {
       
        address etudiant;
        address society;
        uint256 amount;
        uint timestamp;
    }

    mapping(address => Reclamation[]) public reclamations;
    address payable society;


    event ReclamationSubmitted (address indexed user, address indexed society, uint256 amount);
    event FundTransferredToUser(address indexed user, uint256 amount);

    modifier onlyOwner() {
        require(msg.sender == owner, "Not the owner");
        _;
    }

    address payable owner; // Owner to receive funds

    constructor() {
        owner = payable(0x7526fb9605FE387929143f626E82125EAf231B2d);
        
    }
    // that method came after the transfer of the fond by the society
    function submitReclamation(address etudiantAdd,uint256 amount) external payable {
        require(msg.value > 0, "Amount must be greater than 0");

        Reclamation memory newReclamation = Reclamation({
            etudiant:etudiantAdd ,
            society: msg.sender,
            amount: amount,
            timestamp: block.timestamp
        });

        reclamations[msg.sender].push(newReclamation); // Add to etudiant's reclamations
        reclamations[etudiantAdd].push(newReclamation); // Add to society's reclamations
        emit ReclamationSubmitted( msg.sender, etudiantAdd, msg.value);

       
    }

    function getReclamationsByUser() external view returns (Reclamation[] memory) {
        return reclamations[msg.sender];
    }

    

    function transferToUser(address user) external payable{
    require(msg.value > 0, "Amount must be greater than 0");
    payable(user).transfer(msg.value);
    emit FundTransferredToUser(user,msg.value);
}

}
