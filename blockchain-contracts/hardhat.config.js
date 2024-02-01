require("@nomicfoundation/hardhat-toolbox");

require("dotenv").config();
/** @type import('hardhat/config').HardhatUserConfig */

const Sep_URL = process.env.Sep_URL;
const PRIVATE_KEY = process.env.PRIVATE_KEY;
module.exports = {
  solidity: "0.8.17",
  etherscan: {
      apiKey:"7Z9V3BNI8ZIZRRB36WXKGARFR6QKKTN2F6",
  },
  networks: {
    sepolia: {
      url: Sep_URL,
      accounts: [PRIVATE_KEY],
    },
  },
};
