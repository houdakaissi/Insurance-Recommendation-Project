const Migrations = artifacts.require("Contracts");

module.exports = function(deployer) {
    deployer.deploy(Migrations);
};