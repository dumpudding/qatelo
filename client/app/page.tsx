import Image from "next/image";

export default function Home() {
    return (
        <main className="flex h-screen items-center justify-evenly px-10" style={{ backgroundColor: "#FADA5E" }}>
            {/* Left Text Section */}
            <div className="text-left">
                <h1 className="text-6xl font-bold text-black" style={{ fontFamily: "'Libre Baskerville', serif" }}>
                    qatelo.
                </h1>
                <p className="text-lg text-black mt-4">
                    make your undergraduate<br /> community feel like home.
                </p>
            </div>

            {/* Login Card */}
            <div className="relative rounded-lg p-6 shadow-md w-80 text-center" style={{ backgroundColor: "#F1EFD6" }}>
                {/* Increased Margin for Buffer */}
                <h2 className="text-2xl font-bold text-gray-800 mb-32">
                    Log in or Sign up!
                </h2>

                {/* Bear & Panda Positioned Lower */}
                <div className="relative flex justify-center items-end mb-10"> {/* Increased mb-10 to lower both */}
                    {/* Panda - Slightly Behind Green Button */}
                    <Image 
                        src="/designs_folder/panda.png" 
                        alt="Panda" 
                        width={90} 
                        height={90} 
                        className="absolute left-10 bottom-[-30px] z-10"
                    />

                    {/* Bear - Sitting on Green Button */}
                    <Image 
                        src="/designs_folder/bear.png" 
                        alt="Bear" 
                        width={90} 
                        height={90} 
                        className="absolute right-10 bottom-[-20px] z-20"
                    />
                </div>

                {/* Login Button - Bear Sits Here */}
                <button
                    className="relative w-full py-3 px-4 rounded-md text-lg font-semibold mb-3"
                    style={{ backgroundColor: "#355E3B", color: "white", zIndex: 5 }}
                >
                    Create Account 
                </button>

                {/* Create Account Button */}
                <button
                    className="w-full py-2 px-4 rounded-md text-lg font-semibold border border-gray-500 text-gray-700"
                    style={{ backgroundColor: "#EAE8D8" }}
                >
                    Login
                </button>

                {/* Learn More Link */}
                <p className="mt-4 text-sm text-gray-700">
                    <a href="#" className="underline">Learn more</a>
                </p>
            </div>
        </main>
    );
}
