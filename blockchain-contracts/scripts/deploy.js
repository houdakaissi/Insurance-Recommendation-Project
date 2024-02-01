const hre = require("hardhat");

async function main() {
  const [deployer] = await hre.ethers.getSigners(); // Obtenez le compte du déploiement

  // Déployez le contrat d'assurance
  const InsuranceContract = await hre.ethers.getContractFactory("InsuranceContract");
  const insurance = await InsuranceContract.deploy();
  await insurance.deployed();
  console.log("Contrat d'assurance déployé à l'adresse:", insurance.address);

  // Déployez le contrat de réclamation
  const ReclamationContract = await hre.ethers.getContractFactory("ReclamationContract");
  const reclamation = await ReclamationContract.deploy();
  await reclamation.deployed();
  console.log("Contrat de réclamation déployé à l'adresse:", reclamation.address);

  // Imprimez l'adresse du déploiement
  console.log("Adresse du déploiement:", deployer.address);

  // Vous pouvez interagir avec les contrats ici si nécessaire

  // Décommentez les lignes suivantes si vous souhaitez transférer la propriété ou définir les adresses de la société
  // await insurance.setSocietyAddress(societyAddress);
  // await reclamation.setOwnerAddress(ownerAddress);
}

// Utilisez ce modèle pour pouvoir utiliser async/await partout
// et gérer correctement les erreurs.
main().catch((error) => {
  console.error(error);
  process.exitCode = 1;
});



//Deployed contract address: 0x70bA31B2581704b8ECbA426213856B5113060214