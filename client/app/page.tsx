import Image from "next/image";

export default function Home() {
    return (
        <main className="flex h-screen items-center justify-evenly px-20" style={{ backgroundColor: "#FADA5E" }}>
            {/* Left Text Section */}
            <div className="text-left">
                <h1 className="text-6xl font-bold text-black">qatelo.</h1>
                <p className="text-lg text-black mt-4">
                    make your undergraduate<br /> community feel like home.
                </p>
            </div>

            {/* Login Card */}
            <div className="rounded-lg p-6 shadow-md w-80" style={{ backgroundColor: "#F1EFD6" }}>
                <h2 className="text-2xl font-bold text-gray-800">UAlberta Login</h2>
                <div className="mt-6">
                    <button
                        className="w-full py-3 px-4 rounded-md text-lg font-semibold"
                        style={{ backgroundColor: "#355E3B", color: "white" }}
                    >
                        Login with CCID
                    </button>
                </div>
                <p className="mt-4 text-sm text-gray-700 text-center">
                    <a href="#" className="underline">Learn more</a>
                </p>
            </div>
        </main>
    );
}
